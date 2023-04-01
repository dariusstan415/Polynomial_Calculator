package graphicalUserInterface;
import businessLogic.Operations;
import dataModels.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    public Controller(View view){
        this.view=view;

        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 = new Polynomial(view.getFirstPolynomialField().getText());
                Polynomial p2 = new Polynomial(view.getSecondPolynomialField().getText());
                if(p1.getMap().isEmpty() || p2.getMap().isEmpty())
                    JOptionPane.showMessageDialog(null,"Introduceti polinoamele!");
                else {
                    Polynomial q = Operations.add(p1, p2);
                    if (q.getMap().isEmpty())
                        view.getResultPolynomialField().setText("0");
                    else
                        view.getResultPolynomialField().setText(q.toString());
                }
            }
        });
        view.getSubstractButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 = new Polynomial(view.getFirstPolynomialField().getText());
                Polynomial p2 = new Polynomial(view.getSecondPolynomialField().getText());
                if (p1.getMap().isEmpty() || p2.getMap().isEmpty())
                    JOptionPane.showMessageDialog(null, "Introduceti polinoamele!");
                else {
                    Polynomial q = Operations.substract(p1, p2);
                    if (q.getMap().isEmpty())
                        view.getResultPolynomialField().setText("0");
                    else
                        view.getResultPolynomialField().setText(q.toString());
                }
            }
        });
        view.getMultiplyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 = new Polynomial(view.getFirstPolynomialField().getText());
                Polynomial p2 = new Polynomial(view.getSecondPolynomialField().getText());
                if (p1.getMap().isEmpty() || p2.getMap().isEmpty())
                    JOptionPane.showMessageDialog(null, "Introduceti polinoamele!");
                else {
                    Polynomial q = Operations.multiply(p1, p2);
                    if (q.getMap().isEmpty())
                        view.getResultPolynomialField().setText("0");
                    else
                        view.getResultPolynomialField().setText(q.toString());
                }
            }
        });
        view.getDivideButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 = new Polynomial(view.getFirstPolynomialField().getText());
                Polynomial p2 = new Polynomial(view.getSecondPolynomialField().getText());
                if(p1.getMap().isEmpty() || p2.getMap().isEmpty())
                    JOptionPane.showMessageDialog(null,"Introduceti polinoamele!\nAsigurați-vă că al doilea polinom nu este 0 și are gradulânmaimic decât primul polinom");
                else {
                    Polynomial[] q = Operations.division(p1, p2);
                    if (q[0].getMap().isEmpty()) {
                        if (q[1].getMap().isEmpty())
                            view.getResultPolynomialField().setText("q: 0" + " r: 0");
                        else
                            view.getResultPolynomialField().setText("q: 0 " + "r: " + q[1].toString());
                    } else {
                        if (q[1].getMap().isEmpty())
                            view.getResultPolynomialField().setText("q: " + q[0].toString() + " r: 0");
                        else
                            view.getResultPolynomialField().setText("q: " + q[0].toString() + " r: " + q[1].toString());
                    }
                }
            }
        });
        view.getDerivativeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 = new Polynomial(view.getFirstPolynomialField().getText());
                if (p1.getMap().isEmpty())
                    JOptionPane.showMessageDialog(null, "Introduceti polinomul!");
                else {
                    Polynomial q = Operations.derivative(p1);
                    if (q.getMap().isEmpty())
                        view.getResultPolynomialField().setText("0");
                    else
                        view.getResultPolynomialField().setText(q.toString());
                }
            }
        });

        view.getIntegralButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 = new Polynomial(view.getFirstPolynomialField().getText());
                if (p1.getMap().isEmpty())
                    JOptionPane.showMessageDialog(null, "Introduceti polinomul!");
                else {
                    Polynomial q = Operations.integral(p1);
                    if (q.getMap().isEmpty())
                        view.getResultPolynomialField().setText("0");
                    else
                        view.getResultPolynomialField().setText(q.toString());
                }
            }
        });


    }

}
