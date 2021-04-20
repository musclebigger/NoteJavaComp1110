package Interface;

public class ChickenSandwich {
    public static void main(String[] args) {
        Vegetable vegetable = new Vegetable();
        Meat meat = new Meat();
        foodForAll[] foodForAll = new foodForAll[2];
        foodForAll[0] = vegetable;
        foodForAll[1] = meat;
        for(foodForAll food:foodForAll){
            if(food instanceof Meat){
                meat.chicken();
            }
            if (food instanceof Vegetable){
                vegetable.lettuce();
            }
        }
        //Lambda expression to express the code above
        foodForAll x = ()->{return false;};
        System.out.println(x.hasCook());
        //if we would like to use the interface without lambda
        //always use index java inside interface
        foodForAll food = new foodForAll() {
            @Override
            public boolean hasCook() {
                return false;
            }
        };
        System.out.println(food.hasCook());
    }
}