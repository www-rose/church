package com.church.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notem")
public class Notem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "rollNo")
	private String rollNo;
	
	@Column(name = "s1")
	private String S1;
	
	@Column(name = "s2")
	private String S2;
	
	@Column(name = "s3")
	private String S3;
	
	@Column(name = "s4")
	private String S4;
	
	@Column(name = "s5")
	private String S5;
	
	@Column(name = "s6")
	private String S6;
	
	@Column(name = "s7")
	private String S7;
	
	@Column(name = "s8")
	private String S8;
	
	@Column(name = "s9")
	private String S9;
	
	@Column(name = "s10")
	private String S10;
	
	@Column(name = "s11")
	private String S11;
	
	@Column(name = "s12")
	private String S12;
	
	@Column(name = "s13")
	private String S13;
	
	@Column(name = "s14")
	private String S14;
	
	@Column(name = "s15")
	private String S15;
	
	@Column(name = "s16")
	private String S16;
	
	@Column(name = "s17")
	private String S17;
	
	@Column(name = "s18")
	private String S18;
	
	@Column(name = "s19")
	private String S19;
	
	@Column(name = "s20")
	private String S20;
	
	@Column(name = "s21")
	private String S21;
	
	@Column(name = "s22")
	private String S22;
	
	@Column(name = "s23")
	private String S23;
	
	@Column(name = "s24")
	private String S24;
	
	@Column(name = "s25")
	private String S25;
	
	@Column(name = "s26")
	private String S26;
	
	@Column(name = "s27")
	private String S27;
	
	@Column(name = "s28")
	private String S28;
	
	@Column(name = "s29")
	private String S29;
	
	@Column(name = "s30")
	private String S30;
	
	public Notem() {
		
	}


	

	public Notem(String rollNo, String s1, String s2, String s3, String s4, String s5, String s6, String s7,
			String s8, String s9, String s10, String s11, String s12, String s13, String s14, String s15, String s16,
			String s17, String s18, String s19, String s20, String s21, String s22, String s23, String s24, String s25,
			String s26, String s27, String s28, String s29, String s30) {
		super();
		this.rollNo = rollNo;
		S1 = s1;
		S2 = s2;
		S3 = s3;
		S4 = s4;
		S5 = s5;
		S6 = s6;
		S7 = s7;
		S8 = s8;
		S9 = s9;
		S10 = s10;
		S11 = s11;
		S12 = s12;
		S13 = s13;
		S14 = s14;
		S15 = s15;
		S16 = s16;
		S17 = s17;
		S18 = s18;
		S19 = s19;
		S20 = s20;
		S21 = s21;
		S22 = s22;
		S23 = s23;
		S24 = s24;
		S25 = s25;
		S26 = s26;
		S27 = s27;
		S28 = s28;
		S29 = s29;
		S30 = s30;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getRollNo() {
		return rollNo;
	}




	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}




	public String getS1() {
		return S1;
	}




	public void setS1(String s1) {
		S1 = s1;
	}




	public String getS2() {
		return S2;
	}




	public void setS2(String s2) {
		S2 = s2;
	}




	public String getS3() {
		return S3;
	}




	public void setS3(String s3) {
		S3 = s3;
	}




	public String getS4() {
		return S4;
	}




	public void setS4(String s4) {
		S4 = s4;
	}




	public String getS5() {
		return S5;
	}




	public void setS5(String s5) {
		S5 = s5;
	}




	public String getS6() {
		return S6;
	}




	public void setS6(String s6) {
		S6 = s6;
	}




	public String getS7() {
		return S7;
	}




	public void setS7(String s7) {
		S7 = s7;
	}




	public String getS8() {
		return S8;
	}




	public void setS8(String s8) {
		S8 = s8;
	}




	public String getS9() {
		return S9;
	}




	public void setS9(String s9) {
		S9 = s9;
	}




	public String getS10() {
		return S10;
	}




	public void setS10(String s10) {
		S10 = s10;
	}




	public String getS11() {
		return S11;
	}




	public void setS11(String s11) {
		S11 = s11;
	}




	public String getS12() {
		return S12;
	}




	public void setS12(String s12) {
		S12 = s12;
	}




	public String getS13() {
		return S13;
	}




	public void setS13(String s13) {
		S13 = s13;
	}




	public String getS14() {
		return S14;
	}




	public void setS14(String s14) {
		S14 = s14;
	}




	public String getS15() {
		return S15;
	}




	public void setS15(String s15) {
		S15 = s15;
	}




	public String getS16() {
		return S16;
	}




	public void setS16(String s16) {
		S16 = s16;
	}




	public String getS17() {
		return S17;
	}




	public void setS17(String s17) {
		S17 = s17;
	}




	public String getS18() {
		return S18;
	}




	public void setS18(String s18) {
		S18 = s18;
	}




	public String getS19() {
		return S19;
	}




	public void setS19(String s19) {
		S19 = s19;
	}




	public String getS20() {
		return S20;
	}




	public void setS20(String s20) {
		S20 = s20;
	}




	public String getS21() {
		return S21;
	}




	public void setS21(String s21) {
		S21 = s21;
	}




	public String getS22() {
		return S22;
	}




	public void setS22(String s22) {
		S22 = s22;
	}




	public String getS23() {
		return S23;
	}




	public void setS23(String s23) {
		S23 = s23;
	}




	public String getS24() {
		return S24;
	}




	public void setS24(String s24) {
		S24 = s24;
	}




	public String getS25() {
		return S25;
	}




	public void setS25(String s25) {
		S25 = s25;
	}




	public String getS26() {
		return S26;
	}




	public void setS26(String s26) {
		S26 = s26;
	}




	public String getS27() {
		return S27;
	}




	public void setS27(String s27) {
		S27 = s27;
	}




	public String getS28() {
		return S28;
	}




	public void setS28(String s28) {
		S28 = s28;
	}




	public String getS29() {
		return S29;
	}




	public void setS29(String s29) {
		S29 = s29;
	}




	public String getS30() {
		return S30;
	}




	public void setS30(String s30) {
		S30 = s30;
	}




	
}

