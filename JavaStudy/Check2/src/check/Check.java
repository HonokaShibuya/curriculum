package check;

public class Check {
    private String firstName = "萌花";
    private String lastName = "渋谷";
    
    private void printName(String firstName, String lastName) {
        String name = firstName + lastName;
        System.out.println("printNameメソッド → " + name);
    }

    public static void main(String[] args) {
        Check check = new Check();
        check.printName("渋谷", "萌花");
        
        
    
        
        
        Pet pet = new Pet("ポチ", "java太郎");
        RobotPet robotPet = new RobotPet("PXT2", "パンク");
        
        pet.introduce();
        robotPet.introduce();
    }
   
    
    
    
}