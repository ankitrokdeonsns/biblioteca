package com.twu28.biblioteca;

public class User
{    
	private String userName;

	public User(String userName)
	{
		this.userName = userName;
    }


    @Override
    public boolean equals(Object user)
    {
        if(user == null)    throw new RuntimeException("user is null");
        if(this.getClass() != user.getClass())  return false;
        return this.userName.equals(((User)user).getUserName());
    }

    public String getUserName()
    {
        return this.userName;
    }

}
