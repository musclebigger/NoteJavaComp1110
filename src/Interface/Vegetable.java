package Interface;

public class Vegetable implements foodForAll{

    @Override
    public boolean hasCook() {
        return false;
    }

    public void lettuce(){
        if (hasCook()){
            System.out.println("cooked lettuce");
        }else {
            System.out.println("this is lettuce");
        }

    }
}
