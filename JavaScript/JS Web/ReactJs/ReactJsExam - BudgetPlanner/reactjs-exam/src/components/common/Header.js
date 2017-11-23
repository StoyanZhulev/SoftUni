import React, { Component } from 'react';
import { NavLink } from 'react-router-dom';

export default class Header extends Component {


  getCurrentYearAndMonth(){
    let date = new Date();
    let year = date.getFullYear();
    let month = date.getMonth() + 1;

    return year + '/' + month
  }

  getCurrentYear(){
    let date = new Date();
    return date.getFullYear();
  }
    render() {
        const { loggedIn, onLogout, isAdmin } = this.props;

        return (

            <header>
            <nav className="navbar navbar-dark bg-secondary">
              <div className="container">
                <div className="row">
                  <div className="col-md-12">
                    {loggedIn && <NavLink className="nav-link" activeClassName="active"  to={`/plan/${this.getCurrentYearAndMonth()}`}>Monthly Balance</NavLink>}
                    {loggedIn && <NavLink className="nav-link" activeClassName="active" to={`/plan/${this.getCurrentYear()}`}>Yearly Balance</NavLink>}
                    {loggedIn && <a href="javascript:void(0)" onClick={onLogout}>Logout</a>}
                    {!loggedIn && <a className="nav-link" activeClassName="active" href="/login">Login</a>}
                    {!loggedIn && <a className="nav-link " activeClassName="active" href="/register">Register</a>}
                  </div>
                </div>
              </div>
            </nav>
          </header>
        );
    }
}