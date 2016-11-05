package les8.hw.blackList;

/**
 * Created by User on 04.11.2016.
 */
public class Stack {
    private Object [] stack = new Object[10];
    BlackList blackList;


    public Stack() {
        blackList = new BlackList();
        blackList.addClassInBlackList(Integer.class);
        blackList.addClassInBlackList(String.class);
    }

    public void addObject(Object object){
        if(!blackList.isClassInBlackList(object.getClass())) {
            for (int i = 0; i < stack.length; i++) {
                if (stack[i] == null) {
                    stack[i] = object;
                    break;
                }
            }
        }else{
            System.out.println("This class in Black List");
        }
    }

    public Object takeObject(){
        Object result = null;
        for(int i = stack.length - 1; i > -1; i--){
            if(stack[i] != null){
                result = stack[i];
                stack[i] = null;
                break;
            }
        }
        return result;
    }

    public Object getObject(){
        Object result = null;
        for(int i = stack.length - 1; i > -1; i--){
            if(stack[i] != null){
                result = stack[i];
                break;
            }
        }
        return result;
    }

    public Object[] getStack() {
        return stack;
    }
}
