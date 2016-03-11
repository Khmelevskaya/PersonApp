package ua.org.oa.khmelevskayas.model;

public class Person {
    private String name;
    private Integer age;
    private String email;
    
    public String getName(){
	return name;
    }
    
    public void setName(String name){
	this.name = name;
    } 
    
    public String getEmail(){
	return email;
    }
    
    public void setEmail(String email){
	this.email = email;
    }
    
    public Integer getAge(){
	return age;
    }
    
    public void setAge(Integer age){
	this.age = age;
    }
    
 
    public Person(String name, Integer age, String email){
	setName(name);
        setAge(age);
	setEmail(email);
    }

    @Override
    public String toString() {
	return "Person [name=" + name + ", age=" + age + ", email=" + email + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((age == null) ? 0 : age.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Person other = (Person) obj;
	if (age == null) {
	    if (other.age != null)
		return false;
	} else if (!age.equals(other.age))
	    return false;
	if (email == null) {
	    if (other.email != null)
		return false;
	} else if (!email.equals(other.email))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

   
}
