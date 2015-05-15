package com.tinyshop.billgenerator;

import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.tinyshop.model.Customer;

public class PDFGenerator {

	private Customer customer;
	private int subtotal;
	private int netTotal;
	private double total;
	private int tax;
	private PDDocument doc;
	private String billNo;
	private String date;

	public PDFGenerator(Customer customer, double total, String billNo,
			String date) {
		try {
			this.customer = customer;
			this.total = total;
			this.billNo = billNo;
			this.date = date;

			doc = new PDDocument();
			PDPage page = new PDPage();
			doc.addPage(page);
			PDPageContentStream contentStream = new PDPageContentStream(doc,
					page);

			drawBill(page, contentStream);

			contentStream.close();
			doc.save("/home/amilai/test.pdf");
		} catch (COSVisitorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void drawBill(PDPage page, PDPageContentStream contentStream)
			throws IOException {

		String[][] content = {
				{ "Customer No", customer.getCustomerID(), "MyTinyShop Bill" },
				{ "Bill No", "" + billNo, "Date on " + date },
				{ "Name ", customer.getCustomerName(),
						"Customer Type : " + customer.getType() } };
		// now add the text
		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 24);
		contentStream.beginText();
		contentStream.moveTextPositionByAmount(120, 750);
		contentStream.drawString("My Tiny Shop Customer Bill");
		contentStream.endText();
		contentStream.beginText();
		contentStream.moveTextPositionByAmount(220, 720);
		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
		contentStream.drawString("Date on 12/ 09/ 2015");
		contentStream.endText();
		contentStream.drawLine(0, 740, 800, 740);
		// now add the text
		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
		drawTable(page, contentStream, 700, 100, content);
		// now add the text
		contentStream.setFont(PDType1Font.TIMES_ITALIC, 10);
		String[][] content2 = { { "Item No", "Type ", "Units", "Price" },
				{ "GA001", "A", "x", "50.00" }, { "GA001", "A", "x", "50.00" },
				{ "GA001", "A", "x", "50.00" }, { "GA001", "A", "x", "50.00" },
				{ "GA001", "A", "x", "50.00" }, { "GA001", "A", "x", "50.00" }, };
		drawTable(page, contentStream, 640, 100, content2);

		contentStream.setFont(PDType1Font.TIMES_ITALIC, 10);
		String[][] content3 = {
				{ "", "" },
				{ "Total", "" + total },
				{ "Discount (G+C+GC)", "xxx.00" },
				{ "Tax 15%", "xxx.00" },
				{ "SubTotal", "XXXX.00" },
				{ "Payment Mode (Card)",
						customer.getDiscountOnBill() + " (of Net Total)" },
				{ "Net Total", "xxxxx.00" } };
		drawTable(page, contentStream, 500, 100, content3);
	}

	public static void drawTable(PDPage page,
			PDPageContentStream contentStream, float y, float margin,
			String[][] content) throws IOException {
		final int rows = content.length;
		final int cols = content[0].length;
		final float rowHeight = 20f;
		final float tableWidth = page.findMediaBox().getWidth() - (2 * margin);
		final float tableHeight = rowHeight * rows;
		final float colWidth = tableWidth / (float) cols;
		final float cellMargin = 5f;

		float nexty = y;
		for (int i = 0; i <= rows; i++) {
			contentStream.drawLine(margin, nexty, margin + tableWidth, nexty);
			nexty -= rowHeight;
		}

		// draw the columns
		float nextx = margin;
		for (int i = 0; i <= cols; i++) {
			contentStream.drawLine(nextx, y, nextx, y - tableHeight);
			nextx += colWidth;
		}

		float textx = margin + cellMargin;
		float texty = y - 15;
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < content[i].length; j++) {
				if (i == 0) {
					contentStream.setFont(PDType1Font.TIMES_BOLD, 10);
				} else {
					contentStream.setFont(PDType1Font.HELVETICA, 10);
				}
				String text = content[i][j];
				contentStream.beginText();

				contentStream.moveTextPositionByAmount(textx, texty);

				contentStream.drawString(text);
				contentStream.endText();
				textx += colWidth;
			}
			texty -= rowHeight;
			textx = margin + cellMargin;
		}
	}
}