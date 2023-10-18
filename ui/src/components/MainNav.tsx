import {useContext} from 'react';

import {Box, IconButton, useTheme} from '@mui/material';
import InputBase from '@mui/material/InputBase';
import SettingsOutlinedIcon from '@mui/icons-material/SettingsOutlined';
import PersonOutlineOutlinedIcon from '@mui/icons-material/PersonOutlineOutlined';
import SearchIcon from '@mui/icons-material/Search';

import DashboardPage from '../pages/dashboard';
const MainNav = () => {
    return (
        <Box className={'flex justify-between p-2'}>
            <Box className={'flex bg-gray-400 border border-gray-500 border-2 rounded-md'}>
                <InputBase className={'ml-2 flex-1 text-white'} placeholder={'Search'}/>
                <IconButton type={'button'} className={'p-1'}>
                    <SearchIcon htmlColor={"white"}/>
                </IconButton>
            </Box>

            <Box className={'flex'}>
                <IconButton>
                    <SettingsOutlinedIcon htmlColor={"white"}/>
                </IconButton>
                <IconButton>
                    <PersonOutlineOutlinedIcon htmlColor={"white"}/>
                </IconButton>
            </Box>
        </Box>
    );
}
export default MainNav;