import React, { Component } from 'react';
import { Redirect, Route } from 'react-router-dom';
import toastr from 'toastr';

export default class AdminRoute extends Component {
    render() {
        if ( localStorage.getItem('isAdmin') === null) {
            toastr.error('You must be an admin');
            return <Redirect to="/login" />;
        };

        return (
            <Route {...this.props}>
                this.props.children
            </Route>
        );
    }
}