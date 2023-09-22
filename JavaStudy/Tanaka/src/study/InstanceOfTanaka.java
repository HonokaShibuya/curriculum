package study;

public class InstanceOfTanaka {
    private int id = 0;
    private static int staticVarId = 0;
    
    public void incrementId() {
        this.id++;
        System.out.println("id: var       =" + this.id);
        InstanceOfTanaka.staticVarId++;
        System.out.println("id: static var  =" + InstanceOfTanaka.staticVarId);
    }
}