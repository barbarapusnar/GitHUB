public class Vislice extends IgraZaDva implements IIgra{
    private String SkritaBeseda;
    private StringBuffer TrenutnaBeseda=new StringBuffer();
    private StringBuffer prejšnjeČrke=new StringBuffer();
    private int številoČrkDoKonca;
    public Vislice() {
        SkritaBeseda=getSkritaBeseda();
        for (int k=0;k<SkritaBeseda.length();k++)
        {
            TrenutnaBeseda.append("*");
        }
        številoČrkDoKonca=SkritaBeseda.length();
    }
    public String getSkritaBeseda() {
        int x  =(int)(Math.random()*10+1);
        switch (x) {
            case 1:
            return "PRIPEKA";
            case 2:
            return "ZVEZEK";
            case 3:
            return "DEZINFEKTOR";
            case 4:
            return "DALJINEC";
            case 5:
            return "FLOMASTER";
            case 6:
            return "POSODA";
            case 7:
            return "NAVODILA";
            case 8:
            return "KEMIK";
            case 9:
            return "OBESEK";
            case 10:
            return "TORBICA";
                
            default:
                break;
        }
        return "";
    }
    @Override
    public String getPromptIgre() {
        return "\n izberi si eno črko";
    }
    @Override
    public String reportIgra() {
        return "";
    }
    @Override
    public void Igraj(Ivmesnik ui) {
      
        
       while(!konecIgre()){
        IPlayer rač =null;
        ui.report(reportIgra());
        switch (getIgralec()) {
            case 1:
                rač =rač1;
                break;
        
            case 2:
                rač =rač1;
                break;

             default:
                break;
        }
        

    }
        

    }
    @Override
    public boolean konecIgre() {
        return SkritaBeseda.length()==TrenutnaBeseda.length();
    }
    @Override
    public String dobiZmagovalca() {
       
        return "igralec "+getIgralec();
    }
    public boolean UgibajČrko(char črka){
        prejšnjeČrke.append(črka);
        if (SkritaBeseda.indexOf(črka)==-1)
            return false;
        for (int k=0;k<SkritaBeseda.length();k++)
        {
            if (SkritaBeseda.charAt(k)==črka)
            {
                if (TrenutnaBeseda.charAt(k)==črka)
                 return false;
                TrenutnaBeseda.setCharAt(k,črka);
                številoČrkDoKonca--;
            }

        }
        return true;
    }

    public String preglejBesedo(Ivmesnik ui, String s){
        

        return " ";
    }
    public String VzeteČrke(){
        return "";
    }
    
 }
    

