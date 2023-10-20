import {ChangeEvent, FormEvent, useContext, useState} from 'react';

import AuthContext from "../context/AuthProvider"
import {signupFields} from '../constants/formFields';
import FormAction from './FormAction';
import Input from './Input';
import axios from "../api/axios";

const REGISTER_URL = " http://localhost:8080/api/v1/auth/register";

interface Field {
    id: string;
    labelText: string;
    labelFor: string;
    name: string;
    type: string;
    isRequired: boolean;
    placeholder: string;
}

const fields: Field[] = signupFields;

const Register = () => {
    const {setAuth} = useContext(AuthContext);
    const fieldsState: Record<string, string> = {};

    fields.forEach((field) => (fieldsState[field.id] = ''));

    const [signupState, setSignupState] = useState(fieldsState);

    const handleChange = (e: ChangeEvent<HTMLInputElement>) =>
        setSignupState({...signupState, [e.target.id]: e.target.value});

    const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        let isFormValid: boolean = false;
        if (Object.keys(signupState).length === 5) {
            isFormValid = true;
        } else {
            console.log("Please fill all fields")
        }

        if (isFormValid) {
            await createAccount();
        }
        console.log(signupState);
    };

    const createAccount = async () => {
        try {
            const response = await axios.post(REGISTER_URL, signupState, {
                withCredentials: true
            });
            const accessToken = response.data.jwt;
            setAuth({signupState, accessToken});
            console.log(accessToken)

        } catch (error) {
            console.log(error);
        }
    };


    return (
        <form className="mt-8 space-y-6" onSubmit={handleSubmit}>
            <div className="">
                {fields.map((field) => (
                    <Input
                        key={field.id}
                        handleChange={handleChange}
                        value={signupState[field.id]}
                        labelText={field.labelText}
                        labelFor={field.labelFor}
                        id={field.id}
                        name={field.name}
                        type={field.type}
                        isRequired={field.isRequired}
                        placeholder={field.placeholder}
                    />
                ))}
                <FormAction handleSubmit={handleSubmit} text="Signup"/>
            </div>
        </form>
    );
};

export default Register;
