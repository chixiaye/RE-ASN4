package evaluation.basic;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Vector;

public class HandleASN4 {
    public static int fr_num=80;
    public static int nfr_num=3;
    public static HashSet<String> stopWord= new HashSet<String>();
    public static void main(String[] args) {
        stopWord.add("the");
        stopWord.add("a");
        stopWord.add("an");
        stopWord.add("and");
        stopWord.add("be");
        stopWord.add("shall");
        stopWord.add("in");
        stopWord.add("on");
        stopWord.add("is");
        stopWord.add("are");
        stopWord.add("of");
        stopWord.add("as");
        stopWord.add("to");
        stopWord.add("with");

        String re_inputs_path = "/Users/chixiaye/IdeaProjects/ASN4/Input1-Even.txt";
        HashMap<String,Integer> sites = buildSet(re_inputs_path);
        //System.out.println(sites.size());
        int[][] matrix= buildMatrix(fr_num+nfr_num,sites,re_inputs_path);
        int[][] matrix4TfIdf= buildMatrix4TfIdf(fr_num+nfr_num,sites,re_inputs_path);

        // Iterating entries using a For Each loop
        //for (Map.Entry<String, Integer> entry : sites.entrySet()) {
        //    System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue());
        //}
        //write to the res
        String answer_set_path = "/Users/chixiaye/IdeaProjects/ASN4/trace-3nfr-to-80fr.txt";
        String tool_outputs_path1 = "/Users/chixiaye/IdeaProjects/ASN4/based-on-set-overlapping-trace-3nfr-to-80fr.txt";
        String tool_outputs_path2 = "/Users/chixiaye/IdeaProjects/ASN4/based-on-jaccard-index-trace-3nfr-to-80fr.txt";
        String tool_outputs_path3 = "/Users/chixiaye/IdeaProjects/ASN4/based-on-tf-idf-trace-3nfr-to-80fr.txt";

        int[][] ans4SetOverlapping= calBasedOnSetOverlapping(matrix,0.12);
        writeAns(ans4SetOverlapping,tool_outputs_path1);
        int[][] ans4JaccardIndex= calBasedOnJaccardIndex(matrix,0.05);
        writeAns(ans4JaccardIndex,tool_outputs_path2);
        int[][] ans4TfIdf= calBasedOnTfIdf(matrix4TfIdf,0.4);
        writeAns(ans4TfIdf,tool_outputs_path3);
        System.out.println("----------------------------------------------");
        Metrics metrics1= new Metrics(tool_outputs_path1,answer_set_path);
        System.out.println("----------------------------------------------");
//        Metrics metrics2= new Metrics(tool_outputs_path2,answer_set_path);
//        System.out.println("----------------------------------------------");
//        Metrics metrics3= new Metrics(tool_outputs_path3,answer_set_path);

        fr_num=100;
        nfr_num=3;
        String re_inputs_path1 = "/Users/chixiaye/IdeaProjects/ASN4/Input2-Even.txt";
        HashMap<String,Integer> sites1 = buildSet(re_inputs_path1);
        int[][] matrix1= buildMatrix(fr_num+nfr_num,sites1,re_inputs_path1);
        int[][] matrix4TfIdf1= buildMatrix4TfIdf(fr_num+nfr_num,sites1,re_inputs_path1);
        String answer_set_path1 = "/Users/chixiaye/IdeaProjects/ASN4/trace-3nfr-to-100fr.txt";
        String tool_outputs_path11 = "/Users/chixiaye/IdeaProjects/ASN4/based-on-set-overlapping-trace-3nfr-to-100fr.txt";
        String tool_outputs_path21 = "/Users/chixiaye/IdeaProjects/ASN4/based-on-jaccard-index-trace-3nfr-to-100fr.txt";
        String tool_outputs_path31 = "/Users/chixiaye/IdeaProjects/ASN4/based-on-tf-idf-trace-3nfr-to-100fr.txt";

        int[][] ans4SetOverlapping1= calBasedOnSetOverlapping(matrix1,0.12);
        writeAns(ans4SetOverlapping1,tool_outputs_path11);
        int[][] ans4JaccardIndex1= calBasedOnJaccardIndex(matrix1,0.05);
        writeAns(ans4JaccardIndex1,tool_outputs_path21);
        int[][] ans4TfIdf1= calBasedOnTfIdf(matrix4TfIdf1,0.4);
        writeAns(ans4TfIdf1,tool_outputs_path31);
        System.out.println("----------------------------------------------");
        Metrics metrics11= new Metrics(tool_outputs_path11,answer_set_path1);
        System.out.println("----------------------------------------------");
//        Metrics metrics21= new Metrics(tool_outputs_path2,answer_set_path1);
//        System.out.println("----------------------------------------------");
//        Metrics metrics31= new Metrics(tool_outputs_path3,answer_set_path1);


        fr_num=100;
        nfr_num=4;
        String re_inputs_path2 = "/Users/chixiaye/IdeaProjects/ASN4/Input3-Even.txt";
        HashMap<String,Integer> sites2 = buildSet(re_inputs_path2);
        //System.out.println(sites.size());
        int[][] matrix2= buildMatrix(fr_num+nfr_num,sites2,re_inputs_path2);
        int[][] matrix4TfIdf2= buildMatrix4TfIdf(fr_num+nfr_num,sites2,re_inputs_path2);
        // Iterating entries using a For Each loop
        //for (Map.Entry<String, Integer> entry : sites.entrySet()) {
        //    System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue());
        //}
        //String answer_set_path2 = "/Users/chixiaye/IdeaProjects/ASN4/trace-4nfr-to-100fr.txt";
        String answer_set_path2 = "/Users/chixiaye/IdeaProjects/ASN4/trace-4nfr-to-100fr.txt";
        String tool_outputs_path12 = "/Users/chixiaye/IdeaProjects/ASN4/based-on-set-overlapping-trace-4nfr-to-100fr.txt";
        String tool_outputs_path22 = "/Users/chixiaye/IdeaProjects/ASN4/based-on-jaccard-index-trace-4nfr-to-100fr.txt";
        String tool_outputs_path32 = "/Users/chixiaye/IdeaProjects/ASN4/based-on-tf-idf-trace-4nfr-to-100fr.txt";

        int[][] ans4SetOverlapping2= calBasedOnSetOverlapping(matrix2,0.12);
        writeAns2(ans4SetOverlapping2,tool_outputs_path12);
        int[][] ans4JaccardIndex2= calBasedOnJaccardIndex(matrix2,0.05);
        writeAns2(ans4JaccardIndex2,tool_outputs_path22);
        int[][] ans4TfIdf2= calBasedOnTfIdf(matrix4TfIdf2,0.4);
        writeAns2(ans4TfIdf2,tool_outputs_path32);
        System.out.println("----------------------------------------------");
        Metrics2 metrics12= new Metrics2(tool_outputs_path12,answer_set_path2);
        System.out.println("----------------------------------------------");
//        Metrics2 metrics22= new Metrics2(tool_outputs_path22,answer_set_path2);
//        System.out.println("----------------------------------------------");
//        Metrics2 metrics32= new Metrics2(tool_outputs_path32,answer_set_path2);
//        System.out.println("----------------------------------------------");
        //metrics1.f2_ave=0.637010714;
        //metrics11.f2_ave=0.67059929;
        //metrics12.f2_ave=0.64935796;
        //metrics1.f2_ave=0.635225863;
        //metrics11.f2_ave=0.699526127;
        //metrics12.f2_ave=0.671117359;
        double f2_t1Tot2=Math.abs(metrics1.f2_ave-metrics11.f2_ave)/metrics1.f2_ave;
        double f2_t2Tot3=Math.abs(metrics11.f2_ave-metrics12.f2_ave)/metrics11.f2_ave;
        System.out.println("Relative Criteria: "+f2_t1Tot2+", "+f2_t2Tot3);
    }
    public static int[][] calBasedOnTfIdf(int[][] matrix,double threshold){
        int[][] ans=new int[fr_num][nfr_num];
        for(int i=nfr_num;i<fr_num+nfr_num;++i){
            for (int j=0;j<nfr_num;++j){
                double v=0,total1=0,total2=0;
                for(int k=0;k<matrix[0].length;++k){
                    total1+=matrix[i][k];
                    total2+=matrix[j][k];
                    //total1=Math.max(matrix[i][k],total1);
                    //total2=Math.max(matrix[j][k],total2);
                }
                //System.out.println(total1+" : "+total2);
                for(int k=0;k<matrix[0].length;++k){
                    double tfIdf1=matrix[i][k]/total1,tfIdf2=matrix[j][k]/total2;
                    double count=matrix[j][k]==0? 0:1;
                    for(int m=nfr_num;m<nfr_num+fr_num;++m){
                        count= matrix[m][k]==0? count:count++;
                    }
                    tfIdf1*=Math.log((fr_num+1)/(count+1))/Math.log(2.0);
                    tfIdf2*=Math.log((fr_num+1)/(count+1))/Math.log(2.0);
                    v+=tfIdf1*tfIdf2;
                }
                //System.out.println(v);
                ans[i-nfr_num][j]= v>=threshold? 1:0;
            }
        }
        return  ans;
    }
    public static int[][] calBasedOnJaccardIndex(int[][] matrix,double threshold){
        int[][] ans=new int[fr_num][nfr_num];
        for(int i=nfr_num;i<fr_num+nfr_num;++i){
            for (int j=0;j<nfr_num;++j){
                double m11=0,m1=0;
                for(int k=0;k<matrix[0].length;++k){
                    if(matrix[i][k]+matrix[j][k]==2){
                        m11++;
                    }
                    else if(matrix[i][k]+matrix[j][k]==1){
                        m1++;
                    }
                }
                double v=m11/(m1+m11);
                ans[i-nfr_num][j]= v>=threshold? 1:0;
            }
        }
        return  ans;
    }
    public static int[][] calBasedOnSetOverlapping(int[][] matrix,double threshold){
        int[][] ans=new int[fr_num][nfr_num];
        for(int i=nfr_num;i<fr_num+nfr_num;++i){
            for (int j=0;j<nfr_num;++j){
                int R1_size=0,R2_size=0;
                double OverlappingSize=0;
                for(int k=0;k<matrix[0].length;++k){
                    R1_size+=matrix[i][k];
                    R2_size+=matrix[j][k];
                    if(matrix[i][k]+matrix[j][k]==2){
                        OverlappingSize++;
                    }
                }
                double v=2*OverlappingSize/(R1_size+R2_size);
                ans[i-nfr_num][j]= v>=threshold? 1:0;
            }
        }
        return  ans;
    }
    public static int[][] buildMatrix(int num,HashMap<String,Integer> sites,String path){
        File file = new File(path);
        int Len=sites.size();
        int[][] matrix= new int[num][Len];
        for(int i=0;i<num;++i){
            for(int j=0;j<Len;++j){
                matrix[i][j]=0;
            }
        }
        int cnt=0;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String p=line.trim();
                if(p.equals("")) continue;
                String[] trace= p.split(" |\\.|,|:|!|\\(|\\)");
                int i=0;
                for(String s:trace){
                    if(i==0){
                        i++;
                        continue;
                    }
                    String temp=Inflector.getInstance().singularize(s.toLowerCase());
                    if(temp.length()!=0&&sites.containsKey(temp)){
                        matrix[cnt][sites.get(temp)]=1;
                    }
                }
                cnt++;
            }
            return matrix;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int[][] buildMatrix4TfIdf(int num,HashMap<String,Integer> sites,String path){
        File file = new File(path);
        int Len=sites.size();
        int[][] matrix= new int[num][Len];
        for(int i=0;i<num;++i){
            for(int j=0;j<Len;++j){
                matrix[i][j]=0;
            }
        }
        int cnt=0;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String p=line.trim();
                if(p.equals("")) continue;
                //System.out.println(p);
                String[] trace= p.split(" |\\.|,|:|!|\\(|\\)");
                int i=0;
                for(String s:trace){
                    if(i==0 ){
                        i++;
                        continue;
                    }
                    if(s.length()==0)
                        continue;
                    String temp=Inflector.getInstance().singularize(s.toLowerCase());
                    if(temp.length()!=0&&sites.containsKey(temp)){
                        matrix[cnt][sites.get(temp)]++;
                    }
                }
                cnt++;
            }
            return matrix;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static HashMap<String,Integer> buildSet(String path){
        File file = new File(path);
        HashMap<String,Integer> sites = new HashMap<String,Integer>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String p=line.trim();
                if(p.equals("")||p==null) continue;
                String[] trace= p.split(" |\\.|,|:|!|\\(|\\)");
                int i=0;
                for(String s:trace){
                    if(i==0){
                        i++;
                        continue;
                    }
                    if(s.length()==0||stopWord.contains(s.toLowerCase()))
                        continue;
                    String temp=Inflector.getInstance().singularize(s.toLowerCase());
                    if( temp!=null&&temp!=""&&!sites.containsKey(temp)){
                       sites.put(temp,sites.size());
                    }
                }
            }
            return sites;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void writeAns( int[][] ans,String output_path){
        try{
            File file =new File(output_path);
            //if file doesnt exists, then create it
            if(!file.exists()){
                file.createNewFile();
            }
            //true = append file
            FileWriter fileWriter = new FileWriter(file.getName(),false);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            for(int i=0;i<fr_num;++i) {
                int no=i+1;
                String data= "FR"+no+","+ans[i][0]+","+ans[i][1]+","+ans[i][2]+"\n";
                bufferWriter.write(data);
            }
            bufferWriter.close();
            System.out.println("Done"+output_path);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void writeAns2( int[][] ans,String output_path){
        try{
            File file =new File(output_path);
            //if file doesnt exists, then create it
            if(!file.exists()){
                file.createNewFile();
            }
            //true = append file
            FileWriter fileWriter = new FileWriter(file.getName(),false);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            for(int i=0;i<fr_num;++i) {
                int no=i+1;
                String data= "FR"+no+","+ans[i][0]+","+ans[i][1]+","+ans[i][2]+","+ans[i][3]+"\n";
                bufferWriter.write(data);
            }
            bufferWriter.close();
            System.out.println("Done"+output_path);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
