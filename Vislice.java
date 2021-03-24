public class Vislice extends IgraZaDva implements IIgra{
    private String SkritaBeseda;
    private StringBuffer TrenutnaBeseda=new StringBuffer();
    StringBuffer prejšnjeČrke=new StringBuffer();
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
        return "\nIzberi si eno črko";
    }
    @Override
    public String reportIgra() {
        if (!konecIgre())
        return "Beseda "+TrenutnaBeseda.toString()+
        "\nŽe ugibane črke "+prejšnjeČrke.toString();
        else
        return "Zmagal je igralec "+dobiZmagovalca()+
        "\nKONEC IGRE";
    }
    @Override
    public void Igraj(Ivmesnik ui) {
        if(rač1 !=null)
        ui.prompt("Igralec 1 je "+ rač1.toString());
        if(rač2 !=null)
        ui.report("Igralec 2 je "+ rač2.toString());
        while(!konecIgre()){
            IPlayer rač =null;
            ui.report(reportIgra());
            switch (getIgralec()) {
                case 1:
                    rač =rač1;
                    break;

                case 2:
                    rač =rač2;
                    break;

                 default:
                    break;
            }
            char črka =' ';
            if (rač!=null) {
                // da naredi računalnik potezo
                črka = rač.narediPotezo().charAt(0);
                ui.report(rač.toString() + " izbere  "+ črka);
                   UgibajČrko(črka);
                   spremeniIgralca();
            }
            else // igra uporabnik
            {
                ui.prompt(getPromptIgre());
                String odgovor=ui.getUserInput().toUpperCase();
                if (odgovor.length()>1)
                {
                //uporabnik je vnesel celo besedo
                    if (odgovor.equals(SkritaBeseda))
                      {
                          //konec igre
                          številoČrkDoKonca=0;
                      }
                    else
                    {
                        //javi napačno besedo
                        ui.report("Beseda ni prava");
                    }
                }
                else
                {
                črka = odgovor.charAt(0);
                   UgibajČrko(črka);
                   spremeniIgralca(); 
                }
            }
                 
        }
      ui.report(reportIgra());
    }
    @Override
    public boolean konecIgre() {
        return številoČrkDoKonca<=0;
    }
    @Override
    public String dobiZmagovalca() {
       
        return "Igralec "+getIgralec();
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

   
    
 }
    

