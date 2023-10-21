import { ChangeEvent, FormEvent, useState } from 'react';
import { signupFields } from '../constants/formFields';
import FormAction from './FormAction';
import Input from './Input';
import axios from '../api/axios';
import jwtDecode from 'jwt-decode';
import Cookies from 'universal-cookie';

const REGISTER_URL = '/auth/register';

interface Field {
    id: string;
    labelText: string;
    labelFor: string;
    name: string;
    type: string;
    isRequired: boolean;
    placeholder: string;
}

const initialSignupState: Record<string, string> = {};
signupFields.forEach((field) => (initialSignupState[field.id] = ''));

const Register = () => {
    const [signupState, setSignupState] = useState(initialSignupState);
    const cookies = new Cookies();
    const [user, setUser] = useState(null);

    const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
        const { id, value } = e.target;
        setSignupState({ ...signupState, [id]: value });
    };

    const createAccount = async () => {
        try {
            const response = await axios.post(REGISTER_URL, signupState, {
                withCredentials: true,
            });
            const accessToken = response.data.jwt;
            console.log(accessToken);
            await registerUser(signupState);
        } catch (error) {
            console.log(error);
        }
    };

    const registerUser = async (state: any) => {
        try {
            const response = await axios.post(REGISTER_URL, state, {
                withCredentials: true,
            });
            const accessToken = response.data.jwt;
            console.log(accessToken);
            login(accessToken);
        } catch (error) {
            console.log(error);
        }
    };

    const login = (token: string) => {
        const decoded: any = jwtDecode(token);
        setUser(decoded);
        cookies.set('user', decoded, { expires: new Date(decoded.exp * 1000) });
    };

    const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        await createAccount();
        console.log(signupState);
    };

    return (
        <form className="mt-8 space-y-6" onSubmit={handleSubmit}>
            <div className="">
                {signupFields.map((field) => (
                    <Input
                        key={field.id}
                        handleChange={handleChange}
                        value={signupState[field.id]}
                        {...field}
                    />
                ))}
                <FormAction handleSubmit={handleSubmit} text="Signup" />
            </div>
        </form>
    );
};

export default Register;
