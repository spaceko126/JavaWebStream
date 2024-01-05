public class Person{
    public String name;
    public String address;

    public String toString(){
        return "{name="+name+",address="+address"}";
    }
    //hashmap에 원래 tostring 이있는데 person 클래스를 만들어주면 tostring이 없어 깔끔하게 안나옴 상속받기전 tostring을 보여줌
}