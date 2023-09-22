package study;

public class KirbyMain {
    public static void main(String[] args) {
        AbilityOfEnemy aoe = new PlasmaWisp("プラズマはどうだん！！！！");
        aoe.useAbility();
        aoe = new BradeKnight("ひゃくれつぎり！！！");
        aoe.useAbility();
    }
}