package com.programme.server.domain;

import java.io.Serializable;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Years;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.programme.server.json.JsonDateSerializer;

@JsonInclude(Include.NON_NULL)
public final class Player implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String county;
	
	private String club;
	
	@JsonIgnore
	private Date dateOfBirth;
	
	private Integer age;
	
	private Integer number;
	
	private Integer position;
	
	private String image;
	
	private Integer yellowCard;
	
	private Integer redCard;
	
	private Integer blackCard;

	private LiveScoreInfo liveScoreInfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getYellowCard() {
		return yellowCard;
	}

	public void setYellowCard(Integer yellowCard) {
		this.yellowCard = yellowCard;
	}

	public Integer getRedCard() {
		return redCard;
	}

	public void setRedCard(Integer redCard) {
		this.redCard = redCard;
	}

	public Integer getBlackCard() {
		return blackCard;
	}

	public void setBlackCard(Integer blackCard) {
		this.blackCard = blackCard;
	}

	public LiveScoreInfo getLiveScoreInfo() {
		return liveScoreInfo;
	}

	public void setLiveScoreInfo(LiveScoreInfo liveScoreInfo) {
		this.liveScoreInfo = liveScoreInfo;
	}
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", county=" + county + ", club=" + club
				+ ", dateOfBirth=" + dateOfBirth + ", age=" + age + ", number="
				+ number + ", position=" + position + ", image=" + image
				+ ", yellowCard=" + yellowCard + ", redCard=" + redCard
				+ ", blackCard=" + blackCard + ", liveScoreInfo="
				+ liveScoreInfo + "]";
	}

	public void calculateAge(Date dateOfBirth){
		DateTime dateTimeOfBirth = new DateTime(dateOfBirth);
		Years years = Years.yearsBetween(dateTimeOfBirth, new DateTime());
		this.setAge(years.getYears());
	}
	
}
