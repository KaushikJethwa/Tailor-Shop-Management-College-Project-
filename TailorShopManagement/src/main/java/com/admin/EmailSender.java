package com.admin;

public class EmailSender {

	
	public  String createDressHtmlTable(String username) {
		AdminDao adminDao = new AdminDao();
		DressBillPojo billPojo = adminDao.generateDressBill(username);
		
		StringBuilder htmlTable = new StringBuilder();
		htmlTable.append("<table border='1' style='border-collapse:collapse'>");
		htmlTable.append("<tr>");
		htmlTable.append("<th>Name</th><th>Bill No</th><th>Date</th><th>Cloth</th><th>Dress Type</th><th>Measurements</th><th>Advance</th><th>Price</th><th>Total Price</th></tr></thead>" );
        htmlTable.append("<tr>");
        htmlTable.append("<td>").append(billPojo.getName()).append("</td>");
        htmlTable.append("<td>").append(billPojo.getBillNo()).append("</td>");
        htmlTable.append("<td>").append(billPojo.getDate()).append("</td>");
        htmlTable.append("<td>").append("Dress").append("</td>");
        htmlTable.append("<td>").append(billPojo.getDresstype()).append("</td>");
        htmlTable.append("<td>").append("Chest:").append(billPojo.getChest()).append("<br>").append("Shoulder:").append(billPojo.getShoulder()).append("<br>").append("LengthofHand:").append(billPojo.getLengthofhand()).append("<br>").append("LengthofTop:").append(billPojo.getLengthoftop()).append("<br>").append("Waist:").append(billPojo.getWaist()).append("<br>").append("Neck:").append(billPojo.getNeck()).append("<br>").append("LengthofLower:").append(billPojo.getLengthoflower()).append("<br>").append("LengthofBottom:").append(billPojo.getLengthofbottom()).append("</td>");
        htmlTable.append("</td>");
        htmlTable.append("<td>").append(billPojo.getAdvance());
        htmlTable.append("</td>");
        htmlTable.append("<td>").append(billPojo.getPrice());
        htmlTable.append("</td>");
        htmlTable.append("<td>").append((billPojo.getPrice()-billPojo.getAdvance()));
        htmlTable.append("</td>");
        htmlTable.append("</tr>");
        htmlTable.append("<tr>");
        htmlTable.append("<td colspan='5'>").append("Expected Delivery Date:").append(billPojo.getDeliveryDate());
        htmlTable.append("</td>");
        htmlTable.append("<td colspan='5'>").append("For any enquires contact:7710865789");
        htmlTable.append("</td>");
        htmlTable.append("</tr>");
        htmlTable.append("</table>");
        
		return htmlTable.toString();
	}
	
	public String createBlouseHtmlTable(String username) {
		
		AdminDao adminDao = new AdminDao();
		BlouseBillPojo billPojo = adminDao.generateBlouseBill(username);
		
		StringBuilder htmlTable = new StringBuilder();
		htmlTable.append("<table border='1' style='border-collapse:collapse'>");
		htmlTable.append("<tr>");
		htmlTable.append("<th>Name</th><th>Bill No</th><th>Date</th><th>Cloth</th><th>Measurements</th><th>Advance</th><th>Price</th><th>Total Price</th></tr></thead>");
        htmlTable.append("<tr>");
        htmlTable.append("<td>").append(billPojo.getName()).append("</td>");
        htmlTable.append("<td>").append(billPojo.getBillNo()).append("</td>");
        htmlTable.append("<td>").append(billPojo.getDate()).append("</td>");
        htmlTable.append("<td>").append("Blouse").append("</td>");
        htmlTable.append("<td>").append("Chest:").append(billPojo.getChest()).append("<br>").append("Shoulder:").append(billPojo.getShoulder()).append("<br>").append("LengthofHand:").append(billPojo.getLengthofhand()).append("<br>").append("LengthofBlouse:").append(billPojo.getLengthofblouse()).append("<br>").append("Waist:").append(billPojo.getWaist()).append("<br>").append("Neck:").append(billPojo.getNeck()).append("</td>");
        htmlTable.append("</td>");
        htmlTable.append("<td>").append(billPojo.getAdvance());
        htmlTable.append("</td>");
        htmlTable.append("<td>").append(billPojo.getPrice());
        htmlTable.append("</td>");
        htmlTable.append("<td>").append((billPojo.getPrice()-billPojo.getAdvance()));
        htmlTable.append("</td>");
        htmlTable.append("</tr>");
        htmlTable.append("<tr>");
        htmlTable.append("<td colspan='5'>").append("Expected Delivery Date:").append(billPojo.getDeliveryDate());
        htmlTable.append("</td>");
        htmlTable.append("<td colspan='5'>").append("For any enquires contact:7710865789");
        htmlTable.append("</td>");
        htmlTable.append("</tr>");
        htmlTable.append("</table>");
        
		return htmlTable.toString();
	}
	
	public String createDressBlouseHtmlTable(String username) {
		
		AdminDao adminDao = new AdminDao();
		DressBlouseBillPojo billPojo = adminDao.generateDressBlouseBill(username);
		
		StringBuilder htmlTable = new StringBuilder();
		htmlTable.append("<table border='1' style='border-collapse:collapse'>");
		htmlTable.append("<tr>");
		htmlTable.append("<th>Name</th><th>Bill No</th><th>Date</th><th>Cloth</th><th>DressMeasurements</th><th>BlouseMeasurements</th><th>DressPrice</th><th>BlousePrice</th><th>Advance</th><th>Total Price</th></tr></thead>");
        htmlTable.append("<tr>");
        htmlTable.append("<td>").append(billPojo.getName()).append("</td>");
        htmlTable.append("<td>").append(billPojo.getBillNo()).append("</td>");
        htmlTable.append("<td>").append(billPojo.getDate()).append("</td>");
        htmlTable.append("<td>").append(" Dress and Blouse").append("</td>");
        htmlTable.append("<td>").append("DressType:").append(billPojo.getDresstype()).append("<br>").append("Chest:").append(billPojo.getDresschest()).append("<br>").append("Shoulder:").append(billPojo.getDressshoulder()).append("<br>").append("LengthofHand:").append(billPojo.getDresslengthofhand()).append("<br>").append("LengthofTop:").append(billPojo.getDresslengthoftop()).append("<br>").append("Waist:").append(billPojo.getDresswaist()).append("<br>").append("Neck:").append(billPojo.getDressneck()).append("<br>").append("LengthofLower:").append(billPojo.getDresslengthoflower()).append("<br>").append("LengthofBottom:").append(billPojo.getDresslengthofbottom()).append("</td>");
        htmlTable.append("</td>");
        htmlTable.append("<td>").append("Chest:").append(billPojo.getBlousechest()).append("<br>").append("Shoulder:").append(billPojo.getBlouseshoulder()).append("<br>").append("LengthofHand:").append(billPojo.getBlouselengthofhand()).append("<br>").append("LengthofBlouse:").append(billPojo.getLengthofblouse()).append("<br>").append("Waist:").append(billPojo.getBlousewaist()).append("<br>").append("Neck:").append(billPojo.getBlouseneck()).append("</td>");
        htmlTable.append("</td>");
        htmlTable.append("<td>").append(billPojo.getDressprice());
        htmlTable.append("</td>");
        htmlTable.append("<td>").append(billPojo.getBlouseprice());
        htmlTable.append("</td>");
        htmlTable.append("<td>").append(billPojo.getAdvance());
        htmlTable.append("</td>");
        htmlTable.append("<td>").append((billPojo.getDressprice()+billPojo.getBlouseprice())-(billPojo.getAdvance()));
        htmlTable.append("</td>");
        htmlTable.append("</tr>");
        htmlTable.append("<tr>");
        htmlTable.append("<td colspan='5'>").append("Expected Delivery Date:").append(billPojo.getDeliveryDate());
        htmlTable.append("</td>");
        htmlTable.append("<td colspan='5'>").append("For any enquires contact:7710865789");
        htmlTable.append("</td>");
        htmlTable.append("</tr>");
        htmlTable.append("</table>");
        
		return htmlTable.toString();
		
	}
}
