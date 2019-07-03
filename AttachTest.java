package agentmain;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

/**
 *
 */
public class AttachTest {

    public static void main(String[] args) throws Exception {
        for (VirtualMachineDescriptor vmd : VirtualMachine.list()) {
            System.out.println(vmd);
            if (vmd.displayName().contains("TestMainInJar")) {
                VirtualMachine vm = VirtualMachine.attach(vmd);
                vm.loadAgent("/Users/qiaojian/Documents/java-attach/agentmain.jar");
                System.out.println("loaded");
                vm.detach();
                System.out.println("detached");
                break;
            }
        }
    }
}
