public class GlavnoOKno {

    public static void main(String[] args) {
        // Palcke p = new Palcke();
        // Bralec b =new Bralec();
        // b.prompt("Koliko compou bo igralo ?");
        // int m = Integer.parseInt(b.getUserInput());
        // for(int k =0 ;k<0 ;k++){
        //     SlabIgralec rač =new SlabIgralec(p);
        //     p.dodajRačIgralca(rač);
        // }
        // p.Igraj(b);
        Vislice v=new Vislice();
        Bralec b=new Bralec();
        b.prompt("Koliko compou bo igralo ?");
        int m = Integer.parseInt(b.getUserInput());
        for(int k =0 ;k<m ;k++){
            IgralecVislic rač =new IgralecVislic(v);
            v.dodajRačIgralca(rač);
        }
        v.Igraj(b);

    }


}
