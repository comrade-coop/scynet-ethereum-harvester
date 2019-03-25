# harvester-common library

How to integrate in the other projects:
1. Go in harvester-common
2. Open terminal
3. “mvn install” which will package and deploy your project to local repository
4. In the project where used in build.gradle add mavenLocal() and implementation 'ai.scynet.harvester:harvester-common:master-SNAPSHOT'