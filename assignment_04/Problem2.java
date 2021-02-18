abstract class MoodyObject {
    protected abstract String getMood();

    protected abstract void expressFeelings();

    public void queryMood() {
        System.out.println("I feel " + this.getMood() + " today!");
    }
}

class SadObject extends MoodyObject {
    protected String getMood() {
        return "sad";
    }

    public void expressFeelings() {
        System.out.println(" 'wah' 'boo hoo' 'weep' 'sob' 'weep'");
    }

    public String toString() {
        return "Observation: Subject cries a lot";
    }
}

class HappyObject extends MoodyObject {
    protected String getMood() {
        return "happy";
    }

    public void expressFeelings() {
        System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
    }

    public String toString() {
        return "Observation: Subject laughs a lot";
    }
}

class PsychiastristObject {
    public void examine(MoodyObject moodyObject) {
        moodyObject.queryMood();
    }

    public void observe(MoodyObject moodyObject) {
        moodyObject.expressFeelings();
        System.out.println(moodyObject.toString());
    }
}

public class Problem2 {
    public static void main(String[] args) {
        PsychiastristObject psychiastristObject = new PsychiastristObject();

        MoodyObject happyObject = new HappyObject();
        System.out.println("How are you feeling today?");
        psychiastristObject.examine(happyObject);

        System.out.println();

        psychiastristObject.observe(happyObject);

        System.out.println();

        MoodyObject sadObject = new SadObject();
        System.out.println("How are you feeling today?");
        psychiastristObject.examine(sadObject);

        System.out.println();
        psychiastristObject.observe(sadObject);
    }
}