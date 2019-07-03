package agentmain;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class AgentMain {
    public static void agentmain(String agentArgs, Instrumentation inst)
            throws ClassNotFoundException, UnmodifiableClassException,
            InterruptedException {
        System.out.println("Agent Main Done");
        inst.addTransformer(new Transformer(), true);
        inst.retransformClasses(TransClass.class);
    }
}
