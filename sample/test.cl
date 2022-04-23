import nothing1
import nothing2
class Human(){
    Nose nose;
    Hand[2] hands;
    Leg[2] legs;
    int calories;
    bool isHungry;
    def Human(Nose n){
        self.nose = n ;
    }
    def Voice speak(){
        Voice voice; return voice;
    }
    def void eat(Food food, int c){
        calories += c;
        newFood = food;
        while(self.isHungry){
            Food newFood = Food();
            eat(newFood);
            self.isHungry = self.checkIsHungry();
        }
    }
    def bool checkIsHungry(){
        return true;
    }
}
class Woman(Human){
    int age = 0;
    def Woman(int a){
        self.age = a;
    }
    def void main(){
        if(age < 20){
            print('she is teen');
        }
    }
}