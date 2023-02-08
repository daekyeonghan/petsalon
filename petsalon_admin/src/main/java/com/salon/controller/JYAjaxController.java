package com.salon.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salon.dto.Designer;
import com.salon.dto.Item;
import com.salon.dto.Resv;
import com.salon.service.DesignerService;
import com.salon.service.ItemService;
import com.salon.service.ResvService;
import com.salon.service.ScheduleService;
import com.salon.service.Shop_NoticeService;

@RestController
public class JYAjaxController {

	@Autowired
	DesignerService dsservice;
	
	@Autowired
	ItemService iservice;
	
	@Autowired
	ScheduleService schservice;
	
	@Autowired
	ResvService resvservice;
	
	@Autowired
	Shop_NoticeService snservice;

	@RequestMapping("/designerRegi")
	public String register(Model model, Designer designer) {
		try {
			dsservice.register(designer);
			System.out.println("ok");
			// model.addAttribute("obj",designer);
			// model.addAttribute("center",dir+"registerok");
		} catch (Exception e) {
			// model.addAttribute("center",dir+"registerfail");
			e.printStackTrace();
			System.out.println("fail");
		}
		// model.addAttribute("left",dir+"left");

		model.addAttribute("path", "designer/designer_main");
		model.addAttribute("content", "main");
		return "main";
	}
	
	
	 @RequestMapping("/itemTotalPage")
	    public Object itemTotalPage() {
	        int recordsPerPage = 6;
	        int totalPages = 0;

	    	try {
				int totalRecords = iservice.totalitem();
		        totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("failed to get total pages");
			}
	    	
	    //	System.out.println(totalPages);

	        return totalPages;
	    }
	
	 @RequestMapping("/dsitemTotalPage")
	    public Object dsitemTotalPage(String designer_id) {
	        int recordsPerPage = 6;
	        int totalPages = 0;

	    	try {
				int totalRecords = iservice.totaldsitem(designer_id);
		        totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
		  //    System.out.println(totalPages);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("failed to get total pages");
			}
	    	
	    //	System.out.println(totalPages);

	        return totalPages;
	    }
	 
	 @RequestMapping("/resvTotalPage")
	    public Object resvTotalPage() {
	        int recordsPerPage = 15;
	        int totalPages = 0;

	    	try {
				int totalRecords = resvservice.get().size();
		        totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("failed to get total pages");
			}
	    	
	    //	System.out.println(totalPages);

	        return totalPages;
	    }
	 
	 @RequestMapping("/noticeTotalPage")
	    public Object noticeTotalPage() {
	        int recordsPerPage = 7;
	        int totalPages = 0;

	    	try {
				int totalRecords = snservice.get().size();
		        totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("failed to get total pages");
			}
	    	
	    //	System.out.println(totalPages);

	        return totalPages;
	    }
	 
	 @RequestMapping("/monthSchedule")
	 public Object weekSchedule() {
			List<Resv> resvlist = null;
			
			JSONArray scharr = new JSONArray();
			SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				resvlist = resvservice.scheduleList();

				for(Resv resv : resvlist) {
					JSONObject obj = new JSONObject();
					obj.put("title", resv.getDesigner_name()+"\n[ 예약자 : "+resv.getUsername()+" ]\n[ 강아지 : "+resv.getDog_name()+" ]");
					obj.put("start", newDtFormat.format(resv.getSc_date()));
					obj.put("id",resv.getResv_no());
					obj.put("url", "/resvInfo?no="+resv.getResv_no());
					obj.put("backgroundColor", "#313257");
					scharr.add(obj);
				}
		//		System.out.println(scharr);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("fail to load schedule");
			}
		
		 return scharr;
	 }
	 
	 @RequestMapping("/dsSchedule")
	 public Object dsSchedule(String dsid) {
			List<Resv> resvlist = null;
			
			JSONArray dsscharr = new JSONArray();
			SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				resvlist = resvservice.dsScheduleList(dsid);

				for(Resv resv : resvlist) {
					JSONObject obj = new JSONObject();
//					obj.put("title",resv.getUsername()+"("+resv.getDog_name()+")");
					obj.put("title",resv.getUsername()+"\n("+resv.getDog_name()+")");
					obj.put("start", newDtFormat.format(resv.getSc_date()));
					obj.put("url", "/resvInfo?no="+resv.getResv_no());
					obj.put("id", resv.getResv_no());
					dsscharr.add(obj);
				}
//				System.out.println(dsscharr);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("fail to load schedule");
			}
		
		 return dsscharr;
	 }
	 
	 @RequestMapping("/resvDetail")
	 public Object resvDetail(Integer resv_no) {
		 Resv resv = null;
		 
		 try {
			resv = resvservice.selectList(resv_no);

		//	System.out.println(resv_no);
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		 
		 return resv;
	 }
	 
	 @RequestMapping("/monthChart")
	 public Object monthChart(Integer chartYear) {
		 System.out.println(chartYear);
			JSONArray rFix = new JSONArray(); 
			JSONArray rCheck = new JSONArray(); 
			JSONArray rCancel = new JSONArray(); 
			
			JSONArray chartData = new JSONArray();
			
			JSONObject joF = new JSONObject();
			JSONObject joCcl = new JSONObject();
			JSONObject joChk = new JSONObject();
		 
			try {

				
				for(int i = 1; i<=12; i++) {
					rFix.add(resvservice.resvMonthChart(chartYear, i, 1));
					rCancel.add(resvservice.resvMonthChart(chartYear, i, 2));
					rCheck.add(resvservice.resvMonthChart(chartYear, i, 0));
				}
				
				
				joF.put("name", "예약 확정");
				joF.put("data", rFix);
				joCcl.put("name", "예약 취소");
				joCcl.put("data", rCancel);
				joChk.put("name", "미확인");
				joChk.put("data", rCheck);
				
				chartData.add(joF);
				chartData.add(joCcl);
				chartData.add(joChk);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("fail to load chartdata");
			}
		
		 return chartData;
		 
	 }
	 
	 @RequestMapping("/styleChart")
	 public Object styleChart() {
		 List<Resv> resvlist = null;
			
			JSONArray chartData = new JSONArray();
			
			try {
				resvlist = resvservice.styleChart();

				for(Resv resv : resvlist) {
					JSONObject obj = new JSONObject();
					obj.put("name",resv.getItem_name());
					obj.put("y", resv.getRatio());
					obj.put("drilldown", resv.getItem_name());
					chartData.add(obj);
				}
//				System.out.println(dsscharr);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("fail to load chartData");
			}
		
		 return chartData;
	 }

	 @RequestMapping("/styleDogChart")
		public Object styleDogChart(Integer item_id) {
			
		 
			List<Resv> resvlist = null;
			JSONArray doglist = new JSONArray();
			JSONArray chartData = new JSONArray();		
			
				try {
					resvlist = resvservice.styleDogChart(item_id);
					 
						
						for(int i = 0; i<resvlist.size(); i++) {
						
							doglist.add(resvlist.get(i).getDog_breed());
							doglist.add(resvlist.get(i).getRatio());
						}
						
						
						        
						for (int i = 0; i < doglist.size(); i+=2) {
					            JSONArray subArray = new JSONArray();
					            subArray.add(doglist.get(i));
					            subArray.add(doglist.get(i+1));
					            chartData.add(subArray);
					        }
				
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		 return chartData;
		}
	 
	 
	 @RequestMapping("/dogChart")
	 public Object dogChart() {
		 List<Resv> resvlist = null;
			
			JSONArray finalChartData = new JSONArray();
			
			try {
				resvlist = resvservice.styleChart();
				
				
				
				List<Resv> subResvlist = null;
			
				for(Resv resv : resvlist) {
					subResvlist = resvservice.styleDogChart(resv.getItem_id());
					JSONObject obj = new JSONObject();
					JSONArray subChartData = new JSONArray();	
					JSONArray doglist = new JSONArray();
						for(int i = 0; i<subResvlist.size(); i++) {
						
							doglist.add(subResvlist.get(i).getDog_breed());
							doglist.add(subResvlist.get(i).getRatio());
						
						}
						
						for (int i = 0; i < doglist.size(); i+=2) {
				            JSONArray subArray = new JSONArray();
				            
				            subArray.add(doglist.get(i));
				            subArray.add(doglist.get(i+1));
				            subChartData.add(subArray);
				        }
						obj.put("name", resv.getItem_name());
						obj.put("id", resv.getItem_name());
						obj.put("data", subChartData);
						
						finalChartData.add(obj);
//						}
//						
//				        		[{name:'',id:'',data:[[],[],[],[],[]]},{},{},...]
//							
						
					//	System.out.println(finalChartData);
			}
				System.out.println(finalChartData);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
			return finalChartData;
	 }
	 
	 @RequestMapping("/userChart")
	 public Object userChart() {
		 List<Resv> resvlist = null;
			
			JSONArray chartData = new JSONArray();
			
			try {
				resvlist = resvservice.userChart();

				for(Resv resv : resvlist) {
					JSONObject obj = new JSONObject();
					obj.put("name",resv.getUsername());
					obj.put("y", resv.getCnt());
					obj.put("drilldown", resv.getUseremail());
					chartData.add(obj);
				}
				System.out.println(chartData);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("fail to load chartData");
			}
		
		 return chartData;
	 }	
	 
	 @RequestMapping("/designerChart")
	 public Object designerChart() {
		 List<Resv> resvlist = null;
			
			JSONArray chartData = new JSONArray();
			
			try {
				resvlist = resvservice.designerChart(4);

				for(Resv resv : resvlist) {
					JSONObject obj = new JSONObject();
					obj.put("name",resv.getDesigner_name());
					obj.put("y", resv.getCnt());
					obj.put("drilldown", resv.getDesigner_id());
					chartData.add(obj);
				}
				System.out.println(chartData);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("fail to load chartData");
			}
		
		 return chartData;
	 }
//	 @RequestMapping("/itemPageTest")
//	    public Object getItemsByPage(int page, Model model) {
//		 int recordsPerPage = 6;
//	        
//	        List<Item> ilist;
//	    	List<Designer> dlist = null;
//
//	    	try {
//				int totalRecords = iservice.totalitem();
//		        int totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
//
//		        int offset = (page-1)*6;
//				
//		        ilist = iservice.pagingitem(recordsPerPage,offset);
//				
//				dlist = dsservice.get();
//				
//				model.addAttribute("menulist", ilist);
//				model.addAttribute("designerlist", dlist);
//				model.addAttribute("totalPages", totalPages);
//				model.addAttribute("path", "item/item_main");
//				model.addAttribute("content", "main");
//			} catch (Exception e) {
//				e.printStackTrace();
//				model.addAttribute("path", "fragments");
//				model.addAttribute("content", "fail");
//			}
//
//
//	        return "main";
//	    }

	
	
	/*
	 * @RequestMapping("/designerlist") public Object getlist(Model model, Designer
	 * designer) {
	 * 
	 * List<Designer> list = new ArrayList<Designer>(); JSONArray ar = new
	 * JSONArray(); try { list = dsservice.get(); for(Designer ds:list) { JSONObject
	 * obj = new JSONObject(); obj.put("designer_id", ds.getDesigner_id());
	 * obj.put("designer_name", ds.getDesigner_name()); obj.put("designer_photo",
	 * "jyassets/img/"+ds.getDesigner_photo()); obj.put("designer_introduce",
	 * ds.getDesigner_introduce()); ar.add(obj); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * //model.addAttribute(list); return ar; }
	 */

	@RequestMapping("/checkid")
	public Object checkid(String dsid) {
		int result = 0;
		Designer ds = new Designer();
		try {
			ds = dsservice.get(dsid);
			if (ds != null) {
//			System.out.println(ds);
				result = 1;
			} else {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
