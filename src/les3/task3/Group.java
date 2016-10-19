package les3.task3;

/**
 * Created by User on 18.10.2016.
 */
public class Group {
    private Student [] group = new Student[10];
    private String name;

    public Group(String name) {
        this.name = name;
    }

    public Group(){}

    public void addStudent(Student student){
        if(student == null){
            System.out.println("Data about the student is not entered.");
        }
        int count = 0;
        for (int num = 0; num < group.length; num++) {
            if (group[num] == null) {
                group[num] = student;
                return;
            }else{count++;}
        }
        try {
            if(count == 10) {
                throw new MyException();
            }
        }catch(MyException e){
            System.out.println("This group is full.");
        }
    }

    public void delStudent(Student student){
        for (int num = 0; num < group.length; num++) {
            if(group[num] == student) {
                group[num] = null;
                return;
            }
        }
        System.out.println("This student is absent in this group.");
    }

    public Student findStudent(String surname){
        Student result = null;
        for (Student st:group) {
            if(st.getSurname() == surname){
                result = st;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        int numNull = 0;
        for (int i = 0; i < group.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < group.length - i - 1 - numNull; j++) {
                if((group[j] == null || group[j].getSurname() == null)||
                   (group[j+1] == null)||(group[j+1].getSurname() == null)){
                    Student tmp = group[j];
                    group[j] = group[j + 1];
                    group[j + 1] = tmp;
                    numNull++;
                }
                else if ((group[j].getSurname().compareTo(group[j + 1].getSurname()) > 0)){
                    Student tmp = group[j];
                    group[j] = group[j + 1];
                    group[j + 1] = tmp;
                    swapped = true;
                }
            }
            if(!swapped)
                break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append("Group " + name + "{" + System.lineSeparator());
        for (int i = 0; i < group.length; i++) {
            if(group[i] != null) {
                sb.append("  " + group[i].toString() + System.lineSeparator());
            }
        }
        sb.append("}");
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
