import {useState} from 'react';
import {Sidebar, Menu, MenuItem} from 'react-pro-sidebar';
import {Box, IconButton, Typography} from '@mui/material';
import {Link} from 'react-router-dom';
import HomeIcon from '@mui/icons-material/Home';
import PersonIcon from '@mui/icons-material/Person';
import SsidChartOutlinedIcon from '@mui/icons-material/SsidChartOutlined';

const SideNav = () => {
    const [collapsed, setCollapsed] = useState(false);
    const [selected, setSelected] = useState('Dashboard');
    return (
        <Box
        sx={{
            "& .pro-sidebar-inner": {
                backgroundColor: '#1e1e1e',
            },
            "& .pro-icon-wrapper": {
                backgroundColor: 'transparent',
            },
            "& .pro-inner-item": {
                padding: "5px 35px 5px 20px",
            },
            "& .pro-inner-item: hover": {
                color: '#868dfb'
            },
            "& .pro-menu-item--active": {
                color: '#6870fa'
            }
        }}
        >

        </Box>
    )
}

export default SideNav;