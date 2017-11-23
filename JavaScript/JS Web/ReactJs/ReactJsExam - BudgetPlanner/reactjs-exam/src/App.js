import React, { Component } from 'react';
import { Route, Switch, withRouter } from 'react-router-dom';
import RegisterPage from './components/Auth/RegisterPage';

import LoginPage from './components/Auth/LoginPage';
import YearlyBalance from './components/YearlyBalance/YearlyBalance';
import CreatePage from './components/Create/CreatePage';
import Header from './components/common/Header';
import PrivateRoute from './components/common/PrivateRoute';
import AdminRoute from './components/common/AdminRoute';
import MonthlyBalance from './components/MonthlyBalance/MonthlyBalance';





class App extends Component {
    constructor(props) {
        super(props);

        this.onLogout = this.onLogout.bind(this);
    }

    onLogout() {
        localStorage.clear();
        this.props.history.push('/');
    }

    render() {
        return (
            <div className="App">
                <Header loggedIn={localStorage.getItem('authToken') !== null} isAdmin={localStorage.getItem('isAdmin') !== null} onLogout={this.onLogout} />
                <Switch>
                    <PrivateRoute exact path="/plan/:year/:month/expense" component={CreatePage} />
                    
                    <PrivateRoute exact  path="/plan/:year/:month" component={MonthlyBalance} />
                    
                    <PrivateRoute exact path="/plan/:year" component={YearlyBalance} />
                    
                   
                    <Route path="/login" component={LoginPage} />
                    <Route path="/register" component={RegisterPage} />                                      
                </Switch>
            </div>
        );
    }
}

export default withRouter(App);
