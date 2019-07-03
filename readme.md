java attach api + instrument: 动态替换或修改JVM中的类，动态添加classpath

1. mkdir target

2. TransClass.java: 返回1

   public class TransClass {
       public int getNumber() {
           return 1;
       }
   }

3. javac -cp /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/tools.jar *.java -d ./target

4. jar -cvf TestMainInJar.jar -C ./target .

5. vim TestMainInJar.jar, 编辑META-INF/MANIFEST.MF添加Main-Class: agentmain.TestMainInJar

6. java -jar TestMainInJar.jar 

7. 修改TransClass.java: 返回2

   public class TransClass {
       public int getNumber() {
           return 1;
       }
   }

8. 再次编译，javac -cp /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/tools.jar *.java -d ./target

9. 再次打包，jar -cvf agentmain.jar -C ./target .

10. vim agentmain.jar, 编辑META-INF/MANIFEST.MF添加：

    Agent-Class: agentmain.AgentMain

    Can-Retransform-Classes: true

11. 再次打包，jar -cvf attachtest.jar -C ./target .

12. vim attachtest.jar, 编辑META-INF/MANIFEST.MF添加：

    Main-Class: agentmain.AttachTest

    Class-Path: /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/tools.jar

13. 新开窗口先运行TestMainInjar.jar：输出1

    cd /Users/qiaojian/Documents/java-attach

    java -jar TestMainInJar.jar

14. 再运行attachtest.jar：class文件动态替换成功， 输出2

    java -jar attachtest.jar

    