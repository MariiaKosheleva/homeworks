package ua.kosheleva.hw11;

public class Main {
    public static void main(String[] args) {
        Phone referencePhone = new ReferencePhone(100,2,0);
        Phone phone1 = new PushButtonPhone(100, 2,0,7232316);
        Phone phone2 = new SmartPhone(85,1,4, 15);
        Phone phone3 = new VideoPhone(100,2,0,60);

        System.out.println();
        System.out.println(phone1.getClass().getSimpleName());
        phone1.service();
        System.out.println();
        System.out.println(phone2.getClass().getSimpleName());
        phone2.service();
        System.out.println();
        System.out.println(phone3.getClass().getSimpleName());
        phone3.service();

        System.out.println();
        if (phone1 instanceof PushButtonPhone phone11) {
            System.out.println(phone11.getClass().getSimpleName());
            phone11.callTheNumber();
        }
        System.out.println();
        if (phone2 instanceof SmartPhone phone21) {
            System.out.println(phone21.getClass().getSimpleName());
            phone21.checkNewSms();
        }
        System.out.println();
        if (phone3 instanceof VideoPhone phone31) {
            System.out.println(phone31.getClass().getSimpleName());
            phone31.callingWithVideo();
            System.out.println();
        }


        if(phone2.hashCode() == referencePhone.hashCode()){
            System.out.println(phone2.equals(referencePhone));
        }else{
            System.out.println("Hash codes are different");
        }
        System.out.println(phone2.hashCode());
        System.out.println(referencePhone.hashCode());



    }
}
