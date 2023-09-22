package study;

public class BradeKnight extends AbilityOfEnemy {
    public BradeKnight(String attackName) {
        super.attackName = attackName;
    }
    
    @Override
    protected void useAbility() {
        System.out.println(super.attackName);
    }
}