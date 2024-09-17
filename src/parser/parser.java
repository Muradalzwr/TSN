package parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import parser.graph;
import parser.links;
import parser.nodes;
import parser.stream;
import parser.topology;

public class parser {

	//**  get streams from file ***/
public ArrayList<stream> parsestream(String Streampath)
{
	JSONParser parser = new JSONParser();
    ArrayList<stream> streaminput = new ArrayList<stream>();
    try { 
   /// 	List<String> keys = new ArrayList<>((Set<String>) jsonObject.keySet());

		Object obj = parser.parse(new FileReader(Streampath));
        JSONObject jsonObject = (JSONObject) obj;
        for (int i = 0; i <jsonObject.size(); i++ )
        {
         String id = "a208_f" + i ;
         JSONObject attr = (JSONObject) jsonObject.get(id);
         JSONArray src = (JSONArray) attr.get("sources");
         String sourece = src.get(0).toString();
         JSONArray des = (JSONArray) attr.get("destinations");
         String destion = des.get(0).toString();
         String ctns = (String) attr.get("cycle_time_ns").toString();
         int intctns = Integer.parseInt(ctns);
         String fsb = (String) attr.get("frame_size_b").toString();
         int intfsb = Integer.parseInt(fsb);
         String mlns = (String) attr.get("max_latency_ns").toString();
         int intmlns = Integer.parseInt(mlns);
         String dns = (String) attr.get("deadline_ns");
        String red = (String) attr.get("redundancy").toString();
         int intred = Integer.parseInt(red);
        String olb = (String) attr.get("_imd_o_lb").toString();
         int intolb = Integer.parseInt(olb);
        String oub = (String) attr.get("_imd_o_ub").toString();
         int intoub = Integer.parseInt(oub);
        String folb = (String) attr.get("_imd_fo_lb").toString();
         int intfolb = Integer.parseInt(folb);

        String foub = (String) attr.get("_imd_fo_ub").toString();
         int intfoub = Integer.parseInt(foub);

        boolean ctrl = (boolean)  attr.get("_imd_ctrl"); 
         stream Stremk = new stream (id,sourece,destion,intctns ,intfsb ,intmlns,dns,intred,intolb,intoub,intfolb,intfoub,ctrl);

         streaminput.add(Stremk);
        }
        


	}
	catch (FileNotFoundException  e) { e.printStackTrace();}

	catch (IOException  e) { e.printStackTrace();}
	catch (ParseException  e) { e.printStackTrace();}

	catch (Exception  e) { e.printStackTrace();}

	
	
	return streaminput ;
}
public topology parsestopology(String toppath)
{
	
	
	JSONParser parser = new JSONParser();
	
		topology inputtop  = new topology();
		
   	try { 
   		
   		Object obj = parser.parse(new FileReader("C:/Users/dell/Desktop/topology.top"));
           JSONObject jsonObject = (JSONObject) obj;
           boolean dir = (boolean) jsonObject.get("directed");
           boolean mult = (boolean) jsonObject.get("multigraph");
           
           // get graph 
           JSONObject grp = (JSONObject) jsonObject.get("graph");
           String pathabs  = (String) grp.get("path_length_cutoff_abs").toString();
           int intpathabs = Integer.parseInt(pathabs); 
           String pathrel  = (String) grp.get("path_length_cutoff_rel").toString();
           int intpathrel = Integer.parseInt(pathrel);
           String latrel  = (String) grp.get("latency_cutoff_rel").toString();
           int intlatrel = Integer.parseInt(latrel);
          graph inputfrp = new graph (intpathabs ,intpathrel, intlatrel) ;
          //get nodes 
          JSONArray nodesi = (JSONArray) jsonObject.get("nodes");
          ArrayList<nodes> nodesinput = new ArrayList<nodes>();

          for (int i= 0; i < nodesi.size(); i++)
          {
	            JSONObject node = (JSONObject) nodesi.get(i);
	            String nodeid = (String) node.get("id");
	            boolean isswitch = (boolean) node.get("is_switch");
	            String pdns  = (String) node.get("processing_delay_ns").toString();
	            int intpdns = Integer.parseInt(pdns);
	            String fhb  = (String) node.get("fwd_header_b").toString();
	           int intfhb = Integer.parseInt(fhb);
	           int intqpp = 0;
	           if(isswitch == true ) 
	           {
		           String qpp  = (String) node.get("queues_per_port").toString();
		            intqpp = Integer.parseInt(qpp);
	        	   
	           }
	            
	           JSONArray  imp = (JSONArray) node.get("_imd_pos");
	           
	           String imp1  = (String) imp.get(0).toString();
	           double intimp1 = Double.parseDouble(imp1);
	           String imp2  = (String) imp.get(1).toString();
	           double intimp2 = Double.parseDouble(imp2);
	            nodes filenodes = new nodes(nodeid,isswitch, intpdns,intfhb,intqpp,intimp1,intimp2);
	            nodesinput.add(filenodes);

          }
          

          JSONArray links = (JSONArray) jsonObject.get("links");
          ArrayList<links> linksinput = new ArrayList<links>();
          

          for (int i= 0; i < links.size(); i++)
          {
	            JSONObject link = (JSONObject) links.get(i);
	            String key = (String) link.get("key");
	            String source  = (String) link.get("source");
	            String target  = (String) link.get("target");
	            String strdelay  = (String) link.get("propagation_delay_ns").toString();
	           int delay = Integer.parseInt(strdelay);
	           String strspeed  = (String) link.get("link_speed_mbps").toString();
	           int speed = Integer.parseInt(strspeed);
	     links linkinput = new links(key,source,target,delay,speed);
	     linksinput.add(linkinput);
          }
  
     inputtop.setDirected(dir);
     inputtop.setMultigraph(mult);
     inputtop.setGrap(inputfrp);
     inputtop.setNodes(nodesinput);
     inputtop.setLinks(linksinput);



   	}
   	catch (FileNotFoundException  e) { e.printStackTrace();}

   	catch (IOException  e) { e.printStackTrace();}
   	catch (ParseException  e) { e.printStackTrace();}

   	catch (Exception  e) { e.printStackTrace();}
	
       
	return inputtop;
	
}

public parser() {
	super();
	// TODO Auto-generated constructor stub
}
}
