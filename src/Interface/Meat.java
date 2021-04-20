package Interface;

public class Meat implements foodForAll{

    @Override
    public boolean hasCook() {
        return true;
    }

    public void chicken(){
        if(this.hasCook()){
            System.out.println("cooked chicken");
        }else {System.out.println("it is chicken");}

    }

    public boolean c(int input){
        return input%2==0;
    }

}


