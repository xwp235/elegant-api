/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.engine.handler.impl;


import jp.onehr.elegantapi.bpm.engine.Expression;
import jp.onehr.elegantapi.bpm.engine.FlowConstants;
import jp.onehr.elegantapi.bpm.engine.FlowDataTransfer;
import jp.onehr.elegantapi.bpm.engine.assist.Assert;
import jp.onehr.elegantapi.bpm.engine.assist.ObjectUtils;
import jp.onehr.elegantapi.bpm.engine.core.Execution;
import jp.onehr.elegantapi.bpm.engine.core.FlowLongContext;
import jp.onehr.elegantapi.bpm.engine.handler.ConditionNodeHandler;
import jp.onehr.elegantapi.bpm.engine.model.ConditionNode;
import jp.onehr.elegantapi.bpm.engine.model.NodeModel;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 默认流程执行条件处理器
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public class SimpleConditionNodeHandler implements ConditionNodeHandler {
    private static SimpleConditionNodeHandler conditionNodeHandler;

    public static SimpleConditionNodeHandler getInstance() {
        if (null == conditionNodeHandler) {
            synchronized (SimpleConditionNodeHandler.class) {
                conditionNodeHandler = new SimpleConditionNodeHandler();
            }
        }
        return conditionNodeHandler;
    }

    @Override
    public Optional<ConditionNode> getConditionNode(FlowLongContext flowLongContext, Execution execution, NodeModel nodeModel) {
        List<ConditionNode> conditionNodes = nodeModel.getConditionNodes();

        // 根据指定条件节点选择
        String conditionNodeKey = FlowDataTransfer.get(FlowConstants.processSpecifyConditionNodeKey);
        if (null != conditionNodeKey) {
            Optional<ConditionNode> conditionNodeKeyOptional = conditionNodes.stream().filter(t -> Objects.equals(t.getNodeKey(), conditionNodeKey)).findFirst();
            if (conditionNodeKeyOptional.isPresent()) {
                return conditionNodeKeyOptional;
            }
        }

        // 根据正则条件节点选择
        Map<String, Object> args = this.getArgs(flowLongContext, execution, nodeModel);
        Expression expression = flowLongContext.checkExpression();
        Optional<ConditionNode> conditionNodeOptional = conditionNodes.stream()
                .sorted(Comparator.comparing(ConditionNode::getPriorityLevel))
                .filter(t -> expression.eval(t.getConditionList(), args)).findFirst();
        if (conditionNodeOptional.isPresent()) {
            return conditionNodeOptional;
        }

        // 未发现满足条件分支，使用无条件分支
        return defaultConditionNode(conditionNodes);
    }

    public Map<String, Object> getArgs(FlowLongContext flowLongContext, Execution execution, NodeModel nodeModel) {
        Map<String, Object> args = execution.getArgs();
        Assert.illegal(ObjectUtils.isEmpty(args), "Execution parameter cannot be empty");
        return args;
    }

    public Optional<ConditionNode> defaultConditionNode(List<ConditionNode> conditionNodes) {
        Optional<ConditionNode> cnOpt = conditionNodes.stream().filter(t -> ObjectUtils.isEmpty(t.getConditionList())).findFirst();
        Assert.isFalse(cnOpt.isPresent(), "Not found executable ConditionNode");
        return cnOpt;
    }

    @Override
    public Optional<List<ConditionNode>> getInclusiveNodes(FlowLongContext flowLongContext, Execution execution, NodeModel nodeModel) {
        List<ConditionNode> inclusiveNodes = nodeModel.getInclusiveNodes();

        // 根据正则条件节点选择
        Expression expression = flowLongContext.checkExpression();
        Map<String, Object> args = this.getArgs(flowLongContext, execution, nodeModel);
        List<ConditionNode> cnsOpt = inclusiveNodes.stream().filter(t -> expression.eval(t.getConditionList(), args)).collect(Collectors.toList());
        if (ObjectUtils.isEmpty(cnsOpt)) {
            cnsOpt = Collections.singletonList(defaultConditionNode(inclusiveNodes).get());
        }
        return Optional.of(cnsOpt);
    }
}
