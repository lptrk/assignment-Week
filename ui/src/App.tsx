import React from 'react';
import {Routes, Route} from 'react-router-dom';
import MainNav from './components/MainNav';
import SideNav from './components/SideNav';
import DashboardPage from './pages/dashboard';

function App() {
    return (
        <div className={'app'}>
            <SideNav/>
            <main>
                <MainNav/>
                <Routes>
                    <Route path="/" element={<DashboardPage/>}/>

                </Routes>
            </main>
        </div>

    );
}

export default App;
