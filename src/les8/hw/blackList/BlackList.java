package les8.hw.blackList;

/**
 * Created by User on 04.11.2016.
 */
public class BlackList {
    private Class [] blackList = new Class[10];

    public BlackList() {
    }

    public boolean isClassInBlackList(Class clas){
        boolean result = false;
        for(Class element:blackList){
            if(element == clas){
                result = true;
                break;
            }
        }
        return result;
    }

    public void addClassInBlackList(Class clas){
        for(int i = 0; i < blackList.length; i++){
            if(blackList[i] == null){
                blackList[i] = clas;
                break;
            }
        }
    }

    public Class[] getBlackList(){
        return blackList;
    }
}
