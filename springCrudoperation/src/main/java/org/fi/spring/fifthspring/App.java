package org.fi.spring.fifthspring;

import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import org.fi.spring.beans.Category;
import org.fi.spring.config.AppConfigurator;
import org.fi.spring.jdbc.dao.CategoryDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       try(AnnotationConfigApplicationContext applicationContext = new   AnnotationConfigApplicationContext(AppConfigurator.class);
       Scanner sc= new Scanner(System.in))
       {
    	   CategoryDAO daoCategory =(CategoryDAO)applicationContext.getBean("objCategoryDAO");
    	   System.out.println("Enter 1 for add");
    	   System.out.println("Enter 2 for Show");
    	   System.out.println("Enter 3 for update");
    	   System.out.println("Enter 4 for delete");
    	   System.out.println("Enter chice");
    	   int choice = sc.nextInt();
    	   if(choice==1)
    	   {
          System.out.println("Enter CatID");
           int catId= sc.nextInt();
          System.out.println("Enter CatNAme");
          String catName= sc.next();
          System.out.println("Enter CatDescription");
           String catDescription= sc.next();
           System.out.println("Enter CatImage");
           String catImage= sc.next();
       Category objCategory =(Category) applicationContext.getBean("objCategory");
     //  CategoryDAO daoCategory =(CategoryDAO)applicationContext.getBean("objCategoryDAO");
       objCategory.setCategoryId(catId);
       objCategory.setCategoryName(catName);
       objCategory.setCategoryDescription(catDescription);
       objCategory.setCategoryImageUrl(catImage);
       daoCategory.addCategory(objCategory);
       System.out.println("Record Saved Successfully");
    	   }
    	   else if(choice==2)
    	   {
       List<Category> list = daoCategory.getAllCategory();
       for(Category objCategory1 : list)
       {
    	 System.out.println(objCategory1.getCategoryId());
    	 System.out.println(objCategory1.getCategoryName());
    	 System.out.println(objCategory1.getCategoryDescription());
    	 System.out.println(objCategory1.getCategoryImageUrl());
    	System.out.println("----------------------------------------");
       }
    	   }
    	   else if(choice==3)
    	   {
    		   System.out.println("Enter CatID");
               int catId= sc.nextInt();
              System.out.println("Enter CatNAme");
              String catName= sc.next();
              System.out.println("Enter CatDescription");
               String catDescription= sc.next();
               System.out.println("Enter CatImage");
               String catImage= sc.next();
       daoCategory.updateCategory(catId, catName, catDescription, catImage);
       System.out.println("Successful");
    	   }
    	   else if(choice==4)
    	   {
       System.out.println("Category_Id");
       int categoryId = sc.nextInt();
       daoCategory.deleteCategory(categoryId);
       System.out.println("Delete");
    	   }
    }
    }

	
}
