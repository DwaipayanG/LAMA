export default function Login(){
    return (
        <div >
        <h2>Login</h2>

<form >
  <label for="fname">First name:</label>
  <input type="text" id="fname" name="fname" placeholder="John"></input>
  <br>
  </br>
  <label for="lname">Last name:</label>
  <input type="text" id="lname" name="lname" placeholder="Doe"></input>
  <br>
  </br>
  <input type="submit" value="Submit"></input>
</form> 
</div>
    );
};