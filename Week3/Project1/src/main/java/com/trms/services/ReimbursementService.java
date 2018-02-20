package com.trms.services;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.trms.beans.Reimbursement;
import com.trms.daos.ReimbursementDao;
import com.trms.daos.ReimbursementDaoImpl;

public class ReimbursementService {
	public static int insertReimbursement(Reimbursement r) {
		ReimbursementDao dao = new ReimbursementDaoImpl();
		
		String[] s = r.getTimeStr().split(":");
		String t = r.getTimeStr();
		if(s.length == 3) {
			t = String.join(":", s[0], s[1]);
		}
		String result = LocalTime.parse(t, DateTimeFormatter.ofPattern("HH:mm")).format(DateTimeFormatter.ofPattern("hh:mm a"));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
		LocalDateTime ldt = LocalDateTime.parse((r.getDateStr() + " " + result), dtf);
		ZonedDateTime zdt = ldt.atZone(ZoneId.of("Etc/GMT+5"));
		Date d = new Date(zdt.toInstant().toEpochMilli());
		r.setDateTime(ldt);
		r.setDate(d);
		
		r.setUrgent(0);
		return dao.insertReimbursement(r);
	}
}