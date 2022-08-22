import './styles.css'
import book from '../../assets/img/book.svg'

function SignUp() {

    return (
        <div className='container'>
            <div className='name-and-img'>
                <div className='box1'>
                    <h1 className='site_name'>SBOOK</h1>
                    <img src={book} alt="Book" />
                </div>
            </div>
            <div className='signup'>
                <form className='signup-form' action="">
                    <p>sign up</p>
                    <div className='form-config'>
                        <input type="text" placeholder='First name'/>
                        <input type="email" placeholder='E-mail'/>
                        <input type="password" placeholder='Password'/>
                        <input className='button' type="submit" placeholder='Submit'/>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default SignUp;

