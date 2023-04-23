package com.mgp.management;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
public class UserController {
	
	private UserService userService; // user repo
	private User currentUser; // crnt session user
	private CustomerService customerService; // customer repo 
	
	public UserController(UserService userService, CustomerService customerService) {
		super();
		this.userService = userService;
		this.customerService = customerService;
		currentUser = null;
	}
	
	// Handler method (main project)
	
	@GetMapping("/landing")
	public String landing() {
		return "Gymshare/landing";
	}
	
	@GetMapping("/bootstraptest")
	public String bootstrapTest() {
		return "Gymshare/bootstrapTest";
	}
	
	@GetMapping("/login")
	public String login(User user) {
		
		if(user.getPassword() == null) return "Gymshare/login";
	 
			
			User model = userService.getUser(user);
			
			if(model == null || !model.getPassword().equals(user.getPassword())) {
				System.out.println("UserName or Password error "+user.getUserId()+" "+user.getPassword());
				return "Gymshare/login";
			}
			
			currentUser = model;
			
			
			return "Gymshare/landing";

	}
	
	
	
	@GetMapping("/register")
	public String register() {
		return "Gymshare/register";
	}
	
	@GetMapping("/registerNewUser")
	public ModelAndView registerNewUser(@RequestParam("conform-password")String cpwd, User user) {
		
		
		
		/// check is it already exist or not
				//	if(user.getUserId() !="") { System.out.println("I'm still here");
			
			/////////////////////// send this message to front end
			// and also data which we have got (user)
	
			User model = userService.getUser(user);
			
			if(model == null) {
				userService.saveUser(user);
				model = user;
			}

			ModelAndView mdv = new ModelAndView("Gymshare/landing");
			mdv.addObject(model);
			
			// sent message " User already exist" && go to the login page
			if(model !=  null) { 
			return mdv; 
			} 			
			
			if(! cpwd.equals(user.getPassword()) )  {
				
					System.out.println("Password does not match! "+ user.getPassword() +" "+ cpwd ); 
				
					return mdv; 				
				}
			
			userService.saveUser(user); 
	
				
			return mdv;
	}
	
	@GetMapping("/about")
	public String about() {
		return "Gymshare/about";
	}
	
	
	@GetMapping("/bookingpage")
	public String bookingpage() {
		return "Gymshare/bookingpage";
	}
	
	@GetMapping("bookUser")
	public String bookUser(Customer customer) {
		
		if(currentUser == null) return "Gymshare/login";
		
		// else
		customer.setUserId(currentUser.getUserId());
		customer.setPhone(currentUser.getPhone());
		customer.setName(currentUser.getName());
		
		
		////
		
		
		customerService.saveCustomer(customer);
		
		
		////
		
		
		return "Gymshare/landing";
	}
	
	@GetMapping("/bookedList")
	public String getBookedList(Model model){
		
		model.addAttribute("customersList",customerService.getAllCustomers());		
		return "Gymshare/BookedList";
	}
	
	
	@GetMapping("/category")
	public String category() {
		return "Gymshare/category";
	}
	
	@GetMapping("/details")
	public String details() {
		return "Gymshare/details";
	}
	
	@GetMapping("/kl")
	public String kl() {
		return "Gymshare/kl";
	}
	
	@GetMapping("/tn")
	public String tn() {
		return "Gymshare/tn";
	}
	
	/////////////////////////////////TN Districts////////////////////////////////////////////////////
	
	@GetMapping("/Ariyalur")
	public String tnAriyalur(){
		return "Gymshare/tn/Ariyalur";
	}
	
	@GetMapping("/Chennai")
	public String tnChennai(){
		return "Gymshare/tn/Chennai";
	}
	
	@GetMapping("/Chengalpattu")
	public String tnChengalpattu(){
		return "Gymshare/tn/Chengalpattu";
	}
	
	@GetMapping("/Coimbatore")
	public String tnCoimbatore(){
		return "Gymshare/tn/Coimbatore";
	}
	
	@GetMapping("/Cuddalore")
	public String tnCuddalore(){
		return "Gymshare/tn/Cuddalore";
	}
	
	@GetMapping("/Dharmapuri")
	public String tnDharmapuri(){
		return "Gymshare/tn/Dharmapuri";
	}
	
	@GetMapping("/Dindigul")
	public String tnDindigul(){
		return "Gymshare/tn/Dindigul";
	}
	
	@GetMapping("/Erode")
	public String tnErode(){
		return "Gymshare/tn/Erode";
	}
	
	@GetMapping("/Kallakurichi")
	public String tnKallakurichi(){
		return "Gymshare/tn/Kallakurichi";
	}
	
	@GetMapping("/Kancheepuram")
	public String tnKancheepuram(){
		return "Gymshare/tn/Kancheepuram";
	}
	
	@GetMapping("/Kanyakumari")
	public String tnKanyakumari(){
		return "Gymshare/tn/Kanyakumari";
	}
	
	@GetMapping("/Karur")
	public String tnKarur(){
		return "Gymshare/tn/Karur";
	}
	
	@GetMapping("/Krishnagiri")
	public String tnKrishnagiri(){
		return "Gymshare/tn/Krishnagiri";
	}
	
	@GetMapping("/Madurai")
	public String tnMadurai(){
		return "Gymshare/tn/Madurai";
	}
	
	@GetMapping("/Mayiladuthurai")
	public String tnMayiladuthurai(){
		return "Gymshare/tn/Mayiladuthurai";
	}
	
	@GetMapping("/Nagapattinam")
	public String tnNagapattinam(){
		return "Gymshare/tn/Nagapattinam";
	}
	
	@GetMapping("/Namakkal")
	public String tnNamakkal(){
		return "Gymshare/tn/Namakkal";
	}
	
	@GetMapping("/Perambalur")
	public String tnPerambalur(){
		return "Gymshare/tn/Perambalur";
	}
	
	@GetMapping("/Pudukottai")
	public String tnPudukottai(){
		return "Gymshare/tn/Pudukottai";
	}
	
	@GetMapping("/Ramanathapuram")
	public String tnRamanathapuram(){
		return "Gymshare/tn/Ramanathapuram";
	}
	
	@GetMapping("/Ranipet")
	public String tnRanipet(){
		return "Gymshare/tn/Ranipet";
	}
	
	@GetMapping("/Salem")
	public String tnSalem(){
		return "Gymshare/tn/Salem";
	}
	
	@GetMapping("/Sivagangai")
	public String tnSivagangai(){
		return "Gymshare/tn/Sivagangai";
	}
	
	@GetMapping("/Tenkasi")
	public String tnTenkasi(){
		return "Gymshare/tn/Tenkasi";
	}
	
	@GetMapping("/Thanjavur")
	public String tnThanjavur(){
		return "Gymshare/tn/Thanjavur";
	}
	
	@GetMapping("/Theni")
	public String tnTheni(){
		return "Gymshare/tn/Theni";
	}
	
	@GetMapping("/The Nilgiri")
	public String tnNilgiri(){
		return "/Gymshare/tn/The Nilgiri";
	}
	
	@GetMapping("/Thirunelveli")
	public String tnThirunelveli(){
		return "Gymshare/tn/Thirunelveli";
	}
	
	@GetMapping("/Thiruvallur")
	public String tnThiruvallur(){
		return "Gymshare/tn/Thiruvallur";
	}
	
	@GetMapping("/Thiruvarur")
	public String tnThiruvarur(){
		return "Gymshare/tn/Thiruvarur";
	}
	
	@GetMapping("/Tiruchirappalli")
	public String tnTiruchirapalli(){
		return "/Gymshare/tn/Tiruchirappalli";
	}
	
	@GetMapping("/Tirupathur")
	public String tnThirupathur(){
		return "Gymshare/tn/Tirupathur";
	}
	
	@GetMapping("/Tiruppur")
	public String tnTiruppur(){
		return "Gymshare/tn/Tiruppur";
	}
	
	@GetMapping("/Tiruvannamalai")
	public String tnTiruvannamalai(){
		return "/Gymshare/tn/Tiruvannamalai";
	}
	
	@GetMapping("/Thoothukudi")
	public String tnThoothukudi(){
		return "/Gymshare/tn/Thoothukudi";
	}
	
	@GetMapping("/Vellore")
	public String tnVellore(){
		return "/Gymshare/tn/Vellore";
	}
	
	@GetMapping("/Viluppuram")
	public String tnViluppuram(){
		return "/Gymshare/tn/Viluppuram";
	}
	
	@GetMapping("/Virudhunagar")
	public String tnVirudhunagar(){
		return "/Gymshare/tn/Virudhunagar";
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	// Handler method (CRUD testing)
	
	@GetMapping("/index")
	public String index() {		
		return "index";
	}
	
	@GetMapping("/addUser")
	public String addUser(User model) {
		
		userService.saveUser(model);
		return "index";
	}
	
	@GetMapping("/showUser")
	public ModelAndView showUser(User user){
		
		User model = userService.getUser(user);
		
		
		boolean pwd = user.getPassword().equals(model.getPassword());
		
		if(model == null || !pwd) {
			System.out.println( model==null?"User Does not Exist":"User Id or Password Error" );
			return new ModelAndView("index");
		}
				
		// model & view					// passing view
		ModelAndView mav = new ModelAndView("showUser");
		
				
		// model
//		User model = userService.getUser(userid);
		
//		// model into mdv
//		// you should give it a name
//		 
		mav.addObject("model1",model);
		
		
		return mav;
	}
	
	@GetMapping("/updateUser")
	public String updateUser(@RequestParam("userId")String userId) {
		
		deleteUser(userId);		
		return "updateUser";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") String userID) {
		
		userService.deleteUser(userID);		
		return "index";
	}
	
	
	
}
