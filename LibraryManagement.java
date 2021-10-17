import java.util.Scanner;

public class LibraryManagement {
    Scanner in=new Scanner(System.in);
    String[][] books=new String[10][6];
    String[][] student=new String[10][3];   
    int count=0,date,month,duedate,duemonth,k=0,stu=0;    
    String issue,exp;
   
    
    void dispBooks(int count)
    { 
        books[0][0]="I Am Malala";
        books[0][1]="Christ";
        books[1][0]="The Bench";
        books[1][1]="Meghan";
        books[2][0]="Believeee";
        books[2][1]="SRaina";
        books[3][0]="Beautiful";
        books[3][1]="Morgan";
        System.out.println("-------------------------------------------------------------=|");  
        System.out.println(" BOOKS                     |             AUTHOR              ");
        System.out.println("--------------------------------------------------------------|");  
        for(int i=0;i<4+count;i++)
        {
            k++;
            for(int j=0;j<2;j++)
            {
                System.out.print(i+"."+ books[i][j] + "                  \t" );
            }
            System.out.println("");
            System.out.println("___________________________|__________________________________|");  
        }
        System.out.println("-------------------------------------------------------------=|");  
        System.out.println("          --------- BOOK ADDED SUCCESSFULLY -----------    ");
        System.out.println("--------------------------------------------------------------|"); 
    }
    void addBooks(String bookName, String authorName)
    {
        count++;
        books[3+count][0]=bookName;
        books[3+count][1]=authorName;
        dispBooks(count);

    }
    void dispb()
    {
        
        books[0][0]="I Am Malala";
        books[0][1]="Christ";
        books[1][0]="The Bench";
        books[1][1]="Meghan";
        books[2][0]="Believeee";
        books[2][1]="SRaina";
        books[3][0]="Beautiful";
        books[3][1]="Morgan";
        System.out.println("");
        System.out.println(" NOTE ->  NULL MEANS AVAILABE  || LENDED MEANS NOT AVAILABE ");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------|");  
        System.out.println(" BOOKS          |         AUTHOR          |     BOOK STATUS         ");
        System.out.println("-------------------------------------------------------------------|");  
        for(int i=0;i<4+count;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(i+"."+ books[i][j] + "        \t" );
            }
            System.out.println("");
            System.out.println("________________|_________________________|_______________________|"); 
            
        }
        System.out.println("");

    }

    void lendBooks(int sno,String lbookname,String lendername,int ct)
    {
        stu++;
        student[ct][0]=lendername;
        System.out.println(" ENTER YOUR ID ");
        student[ct][1]=in.next();
        System.out.println(" ENTER YOUR PHONE NUMBER ");
        student[ct][2]=in.next();
       

        //PRINT BOOKS DEITALS WITH LENDED INFO

        if(books[sno][0].charAt(0)==lbookname.charAt(0) && (books[sno][2]==null))
        {
            books[sno][2]="lended";
            books[sno][3]=lendername;
        System.out.println("");
        System.out.println(" Enter the lending date ");
        date=in.nextInt();
        System.out.println(" Enter the lending month ");
        month=in.nextInt();
        duedate=date+10;
        
        System.out.println("------------------------------------------------------------------=|");  
        System.out.println("    ---- DEAR "+lendername + ", HERE IS YOUR BILL FOR THE BOOK------  ");
        System.out.println("-------------------------------------------------------------------|"); 
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------|");  
        System.out.println(" BOOKS          |     AUTHOR          |     BOOK STATUS    |    LENDED BY         ");
        System.out.println("---------------------------------------------------------------------------------|");  
        System.out.println(" ");

        
         
            for(int j=0;j<4;j++)
            {
                System.out.print(books[sno][j] + "         \t " );
                
            }
            
        
        if( (duedate>30 && month==4) ||(duedate>30 && month==6) ||(duedate>30 && month==8) 
        || (duedate>30 && month==9) || (duedate>30 && month==11))
        {
            duedate=30-date;
            duemonth=month+1;
        }
        else if((duedate>31 && month==1) || (duedate>31 && month==3) ||(duedate>31 && month==5) 
        || (duedate>31 && month==7) || (duedate>31 && month==10) || (duedate>31 && month==12) )
        {
            duedate=30-date;
            duemonth=month+1;
        }
        else{
            duemonth=month;
        }
        issue=Integer.toString(date).concat("/").concat(Integer.toString(month).concat("/21"));
        exp=Integer.toString(duedate).concat("/").concat(Integer.toString(duemonth).concat("/21"));
        System.out.println("");
        System.out.println("-----------------------------------------------------------------------------=|"); 
        System.out.println(" YOUR DUE DATE IS - > "+ exp);
        System.out.println("------------------------------------------------------------------------------|");
        books[sno][4]=issue;
        books[sno][5]=exp;
        }
        else{
            System.out.println("-------------------------------------------------------------=|");  
            System.out.println("    ---- BOOK ALREADY LENDED OR INNCORECT BOOK NAME ------  ");
            System.out.println("--------------------------------------------------------------|"); 
        }
       
        
    }
    void returnBook(int id,String name)
    {
        System.out.println(" ENTER SUBMISSION DATE ");
        int sdate=in.nextInt();
        System.out.println(" ENTER SUBMISSION MONTH ");
        int smonth=in.nextInt();
        if(duedate>=sdate && duemonth==smonth)
        {
            for(int j=2;j<6;j++)
            {
                books[id][j]=null;
            }
            System.out.println("-------------------------------------------------------------=|");  
            System.out.println("    ---- HI " + name + " YOU SUCCESFULLY RETURNED YOUR BOOK ------  ");
            System.out.println("--------------------------------------------------------------|"); 
            dispb();

        }
        else
        {
            for(int j=2;j<6;j++)
            {
                books[id][j]=null;
            }
            System.out.println("-------------------------------------------------------------=|");  
            System.out.println("    ---- HI " + name + " YOUR DUE DATE IS EXPIRED      ------  ");
            System.out.println("--------------------------------------------------------------|"); 
            System.out.println(" ------------------ YOUR FINE IS Rs -> 100 only -------------- ");

        }
        
       
    }
    void adminView()
    {
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------------------=|");  
        System.out.println("          ------------------------------------  ADMIN VIEW -------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------|"); 
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------|");  
        System.out.println(" BOOKS           |     AUTHOR         |   BOOK STATUS  |  LENDED BY  |   lENDING DATE  |    DUE DATE    | ");
        System.out.println("--------------------------------------------------------------------------------------------------------|");  
        System.out.println(" ");
        for(int i=0;i<k;i++)
        {
            for(int j=0;j<6;j++)
            {
                System.out.print(i+"."+ books[i][j] +"      \t " );
            }
            System.out.println("\n");
            
        }
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------------------=|");  
        System.out.println("          ------------------------------------  STUDENT DETAILS -------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------|");
        System.out.println("");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------|");  
        System.out.println(" STUDENT NAME          |         ID         |     PHONE NUMBER         ");
        System.out.println("-------------------------------------------------------------------|");  
        for(int i=0;i<stu;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(i+"."+ student[i][j] +"             \t   " );
            }
            System.out.println("\n");
            
        }
        System.out.println("-------------------------------------------------------------------|");  
        System.out.println("");

    }
    public static void main(String[] args) {
        
        System.out.println("----------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.println("\t                          LIBRARY MANAGEMENT SYSTEM                             ");
        System.out.println(" ");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println(" ");
        Scanner in=new Scanner(System.in);
       int op,ssno,bno,c=-1,choose=1;
       String bookname,author,bname,aname,na;
       LibraryManagement l=new LibraryManagement();
       while (choose == 1) 
       {
       System.out.println(" CHOOSE THE OPERATION TO PROCEED ");
       System.out.println(" 0. DISPLAY BOOKS");
       System.out.println(" 1. ADD BOOK");
       System.out.println(" 2. LEND BOOKS");
       System.out.println(" 3. RETURN BOOK");
       System.out.println(" 4. ADMIN VIEW");
       op=in.nextInt();
       switch (op) {
           case 0:
           {
               l.dispb();
               break;
           }
           case 1:
           {
            System.out.println(" ENTER THE BOOK NAME ");
            bookname=in.next();
            System.out.println(" ENTER THE AUTHOR NAME ");
            author=in.next();
            l.addBooks(bookname ,author);
            break;
           }
           case 2:
           {
            l.dispb();
            c++;
            System.out.println(" ENTER THE SERIAL NUMBER OF THE BOOK ");
            ssno=in.nextInt();
            System.out.println(" ENTER THE BOOK NAME ");
            bname=in.next();
            System.out.println(" ENTER YOUR NAME ");
            aname=in.next();
            l.lendBooks(ssno, bname, aname, c);
            break;
           }
           case 3:
           {
            System.out.println(" ENTER THE BOOK NUMBER ");
            bno=in.nextInt();
            System.out.println(" ENTER YOUR NAME ");
            na=in.next();
            l.returnBook(bno, na);
            break;
           }
           case 4:
           {
            l.adminView();
            break;
           }

           default:
           {

            break;
           }
               
       }
       
       System.out.println("__________________________________________________________________________________");
       System.out.println("     1 TO CONTINUE                 !!!!!                    0 TO EXIT ");
       choose=in.nextInt();
       System.out.println("__________________________________________________________________________________");
    }     
    }
    
}
