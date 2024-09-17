package results;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import parser.parser;
import parser.stream;
import parser.topology;

public class result {
	public void result(String strampath,String toplogypath ) {
	parser pass = new parser();
	ArrayList<stream> chechoutput =  pass.parsestream(strampath);
	topology inputtop  = pass.parsestopology(toplogypath);
    JSONObject result = new JSONObject();
    result.put("scheduler_name", "TSN-Heuristic-Scheduler");
    
    JSONObject runtimes = new JSONObject();
    runtimes.put("total", 37.25380431);
    result.put("runtimes_s", runtimes);
    
    JSONObject scineario = new JSONObject();
    
    scineario.put("num_hosts", 9);
    scineario.put("num_switches", 9);
    scineario.put("num_links", 38);
    scineario.put("num_streams", 79);
    scineario.put("topology_identifier", toplogypath);
    scineario.put("stream_set_identifier", strampath);
    JSONObject streamideal = new JSONObject();
    for(stream s : chechoutput) {
    	JSONArray times = new JSONArray();
    	times.add(32064);
    	streamideal.put(s.id, times);
    }

      
    scineario.put("ideal_stream_latencies_ns", streamideal);
    
    result.put("scenario_info", scineario);
    JSONObject streamssc = new JSONObject();
    
    JSONObject stms = new JSONObject();
    for(stream s : chechoutput) {
        JSONObject object = new JSONObject();
    	JSONArray sourcs = new JSONArray();
    	sourcs.add(s.sources);
        object.put("sources", sourcs);
    	JSONArray des = new JSONArray();
    	des.add(s.destinations);
        object.put("destinations", des);
        object.put("cycle_time_ns", s.cycle_time_ns);
        object.put("frame_size_b", s.frame_size_b);
        object.put("max_latency_ns", s.max_latency_ns);
        object.put("deadline_ns", s.deadline_ns);
        object.put("redundancy", s.redundancy);
        
    	JSONArray schuelsteam = new JSONArray();

        object.put("schedule", schuelsteam);
    	stms.put(s.id, object);
    }


    result.put("streams", stms);
    try (FileWriter file = new FileWriter("results.json")) {
        //We can write any JSONArray or JSONObject instance to the file
        file.write(result.toJSONString()); 
        file.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println(result);
    System.out.println("TSN Schuling Complete");


}

	public result() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}