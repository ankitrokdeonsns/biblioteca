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
        if(user == null)    return false;
        if(this.getClass() != user.getClass())  return false;
        return this.userName.equals(((User)user).getUserName());
    }

    public String getUserName()
    {
        return this.userName;
    }

}
