package checker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import parser.graph;
import parser.links;
import parser.nodes;
import parser.parser;
import parser.stream;
import parser.topology;

public class checker {
	public void checkstreams(String strampath) {
		
	    JSONObject streamdets = new JSONObject();

		parser pass = new parser();
		ArrayList<stream> chechoutput =  pass.parsestream(strampath);
		for ( stream s : chechoutput) {
			
	        JSONObject streamdetils = new JSONObject();
	 
	        if ( checkstreamscheluding(s) ==true)
	        {
	            JSONArray sourcearray = new JSONArray();
	            sourcearray.add(s.sources);
	        	streamdetils.put("sources" , sourcearray);
	        	  JSONArray des = new JSONArray();
	              des.add(s.destinations);
	          	streamdetils.put("destinations" , des);
	          	streamdetils.put("cycle_time_ns", s.cycle_time_ns);
	          	streamdetils.put("frame_size_b", s.frame_size_b);
	          	streamdetils.put("max_latency_ns", s.max_latency_ns);
	          	streamdetils.put("deadline_ns", s.deadline_ns);
	           	streamdetils.put("deadline_ns", s.deadline_ns);
	           	streamdetils.put("redundancy", s.redundancy);
	           	streamdetils.put("_imd_o_lb", s._imd_o_lb);
	           	streamdetils.put("_imd_o_ub", s._imd_o_ub);
	           	streamdetils.put("_imd_fo_lb", s._imd_fo_lb);
	           	streamdetils.put("_imd_fo_ub", s._imd_fo_ub);
	           	streamdetils.put("_imd_ctrl", s._imd_ctrl);


	        }
	        else {
	        	streamdets.put("sources", "unkwon");
	        }
	        
	        
			
	        if ( checkstreamname(s) ==true)
	        {
	        	streamdets.put(s.id , streamdetils);
	        }
	        else {
	        	streamdets.put("no name", "unkwon");
	        }
	        try (FileWriter file = new FileWriter("streams.json")) {
	            //We can write any JSONArray or JSONObject instance to the file
	            file.write(streamdets.toJSONString()); 
	            file.flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	 
		}

		
	    System.out.println("checker Streams copmleted");

			
	}
	public void checktop(String toppath) {
		
	    JSONObject topobject = new JSONObject();
		parser pass = new parser();
		topology inputtop  = pass.parsestopology(toppath);

	    JSONObject topdetials = new JSONObject();


	    
		
	        if ( checktop(inputtop) ==true)
	        {
	        	topobject.put("directed", inputtop.directed);
	        	topobject.put("multigraph", inputtop.multigraph);
	            JSONObject garphdetials = new JSONObject();
	            graph grp = inputtop.getGrap(); 
	          //  System.out.println(grp.latency_cutoff_rel);

	            garphdetials.put("path_length_cutoff_abs", grp.path_length_cutoff_abs);
	            garphdetials.put("path_length_cutoff_rel", grp.latency_cutoff_rel);
	            garphdetials.put("latency_cutoff_rel", grp.path_length_cutoff_rel);
	        	topobject.put("graph", garphdetials);
	            JSONArray nodesarray = new JSONArray();
	     for ( nodes n : inputtop.nodes )
	     {
	         JSONObject nodedet = new JSONObject();
	         nodedet.put("id",  n.id);
	         nodedet.put("is_switch", n.is_switch);
	         nodedet.put("processing_delay_ns", n.processing_delay_ns);
	         nodedet.put("fwd_header_b", n.fwd_header_b);
	         nodedet.put("queues_per_port", n.queues_per_port);
	         JSONArray ims = new JSONArray();
	         ims.add(0, n.impp1);
	         ims.add(1, n.impp2);
	         nodedet.put("_imd_pos", ims);
	         nodesarray.add(nodedet);
	     }
	 	topobject.put("nodes", nodesarray);
	      
	    JSONArray linksarray = new JSONArray();
	    for ( links l : inputtop.links )
	    {
	        JSONObject linkdet = new JSONObject();
	        linkdet.put("key",  l.key);
	        linkdet.put("source", l.source);
	        linkdet.put("target", l.target);
	        linkdet.put("propagation_delay_ns", l.propagation);
	        linkdet.put("link_speed_mbps", l.delay);
	        linksarray.add(linkdet);

	    }
	 	topobject.put("links", linksarray);

	         //   sourcearray.add(s.sources);
	       // 	streamdetils.put("sources" , sourcearray);
	      

	        }
	        else {
	        	topdetials.put("topolgy", "unkwon");
	        }
	        
	        
		
	  
	        try (FileWriter file = new FileWriter("top.json")) {
	            //We can write any JSONArray or JSONObject instance to the file
	            file.write(topobject.toJSONString()); 
	            file.flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	 


		
	    System.out.println(" Topology checker copmleted");

			
	}




	public boolean checkstreamname(stream k) {
		
		if (k.id != null)
		{
			return true;
		} else {
			return false;
		}
		
	}

	public boolean checktop(topology k) {
		
		if (k.directed == true && k.multigraph == true )
		{
			return true;
		} else {
			return false;
		}
		
	}
	public boolean checkstreamscheluding(stream k) {
		
		if (k.sources != null && k.destinations != null)
		{
			return true;
		} else {
			return false;
		}
		
	}
		public checker() {
			super();
			// TODO Auto-generated constructor stub
		}
}
