package com.example.demo;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.auth.AWSStaticCredentialsProvider;

@SessionAttributes("uses")
@Controller
public class ProjectController {

	
		
	
	@GetMapping(value = "/")
	public ModelAndView Startpage() {
		
		ModelAndView indexPage = new ModelAndView();
		indexPage.setViewName("index");
		return indexPage;
	}
	
	
	@GetMapping(value = "/facebook")
	public ModelAndView renderFb() {
		
		ModelAndView indexPage = new ModelAndView();
		indexPage.setViewName("facebooklogin");
		return indexPage;
	}
		
	
	@Autowired
	private userRepository userRepo;
	
	@ModelAttribute("uses")
	public UserTable setuForm() {
		return new UserTable();
	}
	
	@PostMapping(value = "/facebookredirect")
	public ModelAndView handleredirect(
			@RequestParam(name="myID") String id,
			@RequestParam(name="myName") String name,
			@RequestParam(name="myFriends") String myfriends,
			@RequestParam(name="myEmail") String email,
//			@RequestParam(name="myDescription") String description,
//			@RequestParam(name="file") MultipartFile image, 
			@ModelAttribute("uses") UserTable uses,
			HttpServletRequest req			
			) {
//		System.out.println(id+"is" + name+ "is" + myfriends +"is" + email+ "is");
//			String[] splitted = myfriends.split("/");
//			for(int i =0; i< splitted.length; i++) {
//				System.out.println(i+ " :" +splitted[i]);
//			}
			UserTable u = new UserTable();
			
			BigInteger n=new BigInteger(id);
			u.setId(n.toString());
			uses.setId(n.toString());
			u.setName(name);
			uses.setName(name);
			u.setMyfriends(myfriends);
			uses.setMyfriends(myfriends);
			u.setEmail(email);
			uses.setEmail(email);
//			u.getDescription();
			

			
			if (userRepo.findById(id) == null) {
			
			userRepo.save(u);
			ModelAndView mv1 = new ModelAndView();
			UserTable uservalue = userRepo.findById(id);
			mv1.addObject("username", uservalue.getName());
			
			mv1.setViewName("createprofile");
			return mv1;
			}
			else {
				
				u.setDescription(uses.getDescription());
				u.setImage(uses.getImage());
				ModelAndView mv2 = new ModelAndView();
				UserTable uservalue1 = userRepo.findById(id);
				mv2.addObject("username",uservalue1.getName());
				mv2.addObject("userdes", uservalue1.getDescription());
				mv2.addObject("imgsrc", uservalue1.getImage());
				mv2.setViewName("userprofile");
				return mv2;
			}
			
			
			}
	
	
	@PostMapping(value="/upload")
	public ModelAndView uploadtoS3(
			@RequestParam("file") MultipartFile image,
			@ModelAttribute("uses") UserTable uses,
			@RequestParam(name="myDescription") String description
			) {
		ModelAndView profilePage = new ModelAndView();
			System.out.println("Name sess:" + uses.getId());
			
			System.out.println("ACCESS:" + System.getenv());
			
		
		BasicAWSCredentials credentials = new BasicAWSCredentials(System.getenv("accessKey"),System.getenv("secretKey"));
		AmazonS3 s3clt = AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.US_EAST_2)
				.build();
		try {	
		PutObjectRequest putobreq = new PutObjectRequest("rutujabucket1",image.getOriginalFilename(),image.getInputStream(), new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead);			
			
		s3clt.putObject(putobreq);
			
	
			String imgsrc1 = "http://" + "rutujabucket1" + ".s3.amazonaws.com/"+image.getOriginalFilename();
			profilePage.addObject("imgsrc", imgsrc1);
			
			
			
			UserTable user = new UserTable();
			user.setDescription(description);
			uses.setDescription(description);
			uses.setImage(imgsrc1);
			userRepo.save(uses);
//	//		ModelAndView mv2 = new ModelAndView();
			UserTable userdes = userRepo.findById(user.getId());
			UserTable username = userRepo.findById(uses.getName());
			profilePage.addObject("userdes", user.getDescription());
			profilePage.addObject("username", uses.getName());
			

			profilePage.setViewName("userprofile");
			return profilePage;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			profilePage.setViewName("error");
			return profilePage;

		}
	}
	
	@GetMapping(value = "/friends")
	public ModelAndView renderfriends(
			@ModelAttribute("uses") UserTable uses) {
		ModelAndView indexPage = new ModelAndView();
		
		String friends = new String(uses.getMyfriends());
		System.out.println("Friends" + uses.getMyfriends());
		String[] Singlefriend = friends.split("[/]");
		//String[] sfriend = new String[100];
		ArrayList<String> list=new ArrayList<String>();
		for (int i=0; i< Singlefriend.length; i++) {
			System.out.println("Friends" + Singlefriend[i]);
			String[] friendData = Singlefriend[i].split("[.]");
			System.out.println("Frienddata" + friendData[1]);
			 
			list.add(friendData[1]);
		}
		
		indexPage.addObject("sfriend", list);
		
		indexPage.setViewName("allfriends");
		return indexPage;
	}
	
	@GetMapping(value="/profile")
	public ModelAndView renderprofile(
			@ModelAttribute("uses") UserTable uses) {
		
		ModelAndView profilePage = new ModelAndView();
		
		profilePage.addObject("username",uses.getName());
		profilePage.addObject("imgsrc",uses.getImage());
		profilePage.addObject("userdes",uses.getDescription());
		profilePage.setViewName("userprofile");
		return profilePage;
	}


}
