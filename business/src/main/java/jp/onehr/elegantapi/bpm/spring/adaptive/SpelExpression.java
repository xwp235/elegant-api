/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.spring.adaptive;

import jp.onehr.elegantapi.bpm.engine.Expression;
import jp.onehr.elegantapi.bpm.engine.model.NodeExpression;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Spring el表达式解析器
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author ximu
 * @since 1.0
 */
public class SpelExpression implements Expression {
    private final ExpressionParser parser;

    public SpelExpression() {
        parser = new SpelExpressionParser();
    }

    @Override
    public boolean eval(List<List<NodeExpression>> conditionList, Map<String, Object> args) {
        return this.eval(conditionList, () -> args, expr -> {
            EvaluationContext context = new StandardEvaluationContext();
            for (Entry<String, Object> entry : args.entrySet()) {
                context.setVariable(entry.getKey(), entry.getValue());
            }
            return parser.parseExpression(expr).getValue(context, Boolean.class);
        });
    }

}
