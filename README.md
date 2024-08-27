java -Djarmode=tools -jar log.jar extract --destination application
java -XX:ArchiveClassesAtExit=application.jsa -Dspring.context.exit=onRefresh -jar test-app.jar
java -XX:SharedArchiveFile=log.jsa -jar log.jar
