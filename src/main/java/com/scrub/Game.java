package com.scrub;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/*
{
"user" : {"id": 123,"name":"Ishan", "email":"ishan@mail.com"},
"id" :345,
"name": "xyz",
"answer": "Train",
"category": "Vehicle",
"shareWith": [
"jo@email.com",
"jotest@email.com",
"adriand@email.com",
"donald@email.com"
],
"hint": "very long",
"bestScore": 50,
"bestGuesser": {"id": 123,"name":"Ishan", "email":"ishan@mail.com"},
"imageData":"TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCBieSB0aGlzIHNpbmd1bGFyIHBhc3Npb24gZnJvbSBvdGhlciBhbmltYWxzLCB3aGljaCBpcyBhIGx1c3Qgb2YgdGhlIG1pbmQsIHRoYXQgYnkgYSBwZXJzZXZlcmFuY2Ugb2YgZGVsaWdodCBpbiB0aGUgY29udGludWVkIGFuZCBpbmRlZmF0aWdhYmxlIGdlbmVyYXRpb24gb2Yga25vd2xlZGdlLCBleGNlZWRzIHRoZSBzaG9ydCB2ZWhlbWVuY2Ugb2YgYW55IGNhcm5hbCBwbGVhc3VyZS4="
}
 */
@XmlRootElement
public class Game {

    Integer id;
	String name;
    User user;
    List<String> shareWith = new ArrayList<String>();
    String category;
    String answer;
    String hint;
    Integer bestScore;
    User bestGuesser;
    String imageData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getShareWith() {
        return shareWith;
    }

    public void setShareWith(List<String> shareWith) {
        this.shareWith = shareWith;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Integer getBestScore() {
        return bestScore;
    }

    public void setBestScore(Integer bestScore) {
        this.bestScore = bestScore;
    }

    public User getBestGuesser() {
        return bestGuesser;
    }

    public void setBestGuesser(User bestGuesser) {
        this.bestGuesser = bestGuesser;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    @Override
	public String toString() {
		return "Game [name=" + name +"]";
	}

}
