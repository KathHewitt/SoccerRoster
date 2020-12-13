/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

/**
 *
 * @author kathr_000
 */
public class Player {
	public final String NO_NAME = "No name given.";
	public final int NO_JERSEY = -1;
	public final int NO_RATING = -1;
	
	private String name;
	private Integer jerseyNum;
	private Integer rating;
	
	public Player() {
		name = NO_NAME;
		jerseyNum = NO_JERSEY;
		rating = NO_RATING;
	}
	
	public Player(String n, Integer j, Integer r) {
		name = n;
		jerseyNum = j;
		rating = r;
	}
	
	@Override
	public String toString() {
		return (name + " has jersey number " + jerseyNum + " and rating " + rating);
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getJerseyNum() {
		return jerseyNum;
	}
	
	public Integer getRating() {
		return rating;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setJerseyNum(Integer j) {
		jerseyNum = j;
	}
	
	public void setRating(Integer r) {
		rating = r;
	}
}
