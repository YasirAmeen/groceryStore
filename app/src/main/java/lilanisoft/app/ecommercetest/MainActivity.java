package lilanisoft.app.ecommercetest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MainActivity extends AppCompatActivity {


    private TextView _cart_items;
    int cartItems = 0;

    int _egg = 0;
    int _small = 0;
    int _medium = 0;
    int _large = 0;
    float olpersMilk =0.0f;
    float _fMillk =0.0f;
    private Button _button_egg,_button_wheat,_button_milk;
    private Session session = null;
    private ProgressDialog pdialog;
    private String uname;
    private String pass;
    private AlertDialog.Builder builder;
    private String email;
    private String addres;
    private int _brownBreadSmall=0;
    private int _brownBreadMedium = 0;
    private int _brownBreadLarge;
    private int _whiteBreadSmall =0;
    private int _whiteBreadMedium =0;
    private int _whiteBreadLarge = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _cart_items = (TextView) findViewById(R.id.cart_items);
        _button_egg = (Button) findViewById(R.id.egg_btn);
        _button_wheat = (Button) findViewById(R.id.button_wheat);
        _button_milk = (Button) findViewById(R.id.button_milk);

        setupListener();
    }

    private void setupListener() {
        final String[] eggstype = {"1 dozen", "2 dozen", "3 dozen", "4 dozen","5 dozen","6 dozen"};
        _button_egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                 builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Egg Per Dozen")
                        .setItems(eggstype, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String selectedEgg = eggstype[i];
                                if(selectedEgg.equals("1 dozen")) {
                                    _egg = _egg + 1;
                                    cartItems = cartItems + 1;
                                    _cart_items.setText("Items in cart : "+cartItems );

                                }else if(selectedEgg.equals("2 dozen")) {
                                    _egg = _egg + 2;
                                    cartItems = cartItems + 1;
                                    _cart_items.setText("Items in cart : "+cartItems );

                                }else if(selectedEgg.equals("3 dozen")) {
                                    _egg = _egg + 3;
                                    cartItems = cartItems + 1;
                                    _cart_items.setText("Items in cart : "+cartItems );

                                }else if(selectedEgg.equals("4 dozen")) {
                                    _egg = _egg + 4;
                                    cartItems = cartItems + 1;
                                    _cart_items.setText("Items in cart : "+cartItems );

                                }else if(selectedEgg.equals("5 dozen")) {
                                    _egg = _egg + 5;
                                    cartItems = cartItems + 1;
                                    _cart_items.setText("Items in cart : "+cartItems );

                                }else if(selectedEgg.equals("6 dozen")) {
                                    _egg = _egg + 6;
                                    cartItems = cartItems + 1;
                                    _cart_items.setText("Items in cart : "+cartItems );

                                }
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });


        _button_milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] milkSelection = {"Olpers Milk", "Fresh Milk"};
               builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Milk")
                        .setItems(milkSelection, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String selectedMilktype = milkSelection[i];
                                if(selectedMilktype.equals("Olpers Milk")){


                                    final String[] OplersMilk = {"0.5 litre (30 Rs)","1 litre (120 Rs)","1.5 litre (170 Rs)"};

                                    builder = new AlertDialog.Builder(MainActivity.this);
                                    builder.setTitle("Olpers Milk")
                                            .setItems(OplersMilk, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {

                                                    String olpersmilk = OplersMilk[i];

                                                    if(olpersmilk.equals("0.5 litre (30 Rs)")) {
                                                        olpersMilk = olpersMilk + 0.5f;
                                                        cartItems = cartItems + 1;
                                                        _cart_items.setText("Items in cart : "+cartItems );

                                                    }else if(olpersmilk.equals("1 litre (120 Rs)")) {
                                                        olpersMilk = olpersMilk + 1f;
                                                        cartItems = cartItems + 1;
                                                        _cart_items.setText("Items in cart : "+cartItems );


                                                    } if(olpersmilk.equals("1.5 litre (170 Rs)")) {
                                                        olpersMilk = olpersMilk + 1.5f;
                                                        cartItems = cartItems + 1;
                                                        _cart_items.setText("Items in cart : "+cartItems );


                                                    }
                                                    //Toast.makeText(MainActivity.this, selectedCountry, Toast.LENGTH_SHORT).show();
                                                }
                                            });

                                    AlertDialog dialog = builder.create();
                                    dialog.show();
                                }else {

                                    final String[] freshMilk = {"0.5 Litre - 40Rs","1.0 Litre - 80Rs","2 Litre - 160Rs","3 Litre - 240Rs","4 Litre - 320Rs","5 Litre - 400Rs"};

                                    builder = new AlertDialog.Builder(MainActivity.this);
                                    builder.setTitle("Fresh Milk")
                                            .setItems(freshMilk, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {

                                                    String freshmilk = freshMilk[i];
                                                    if(freshmilk.equals(freshMilk[0])) {
                                                        _fMillk = _fMillk + 0.5f;
                                                        cartItems = cartItems + 1;
                                                        _cart_items.setText("Items in cart : "+cartItems );

                                                    }else if(freshmilk.equals(freshMilk[1])) {
                                                        _fMillk = _fMillk + 1f;
                                                        cartItems = cartItems + 1;
                                                        _cart_items.setText("Items in cart : "+cartItems );

                                                    }else if(freshmilk.equals(freshMilk[2])) {
                                                        _fMillk = _fMillk + 2f;
                                                        cartItems = cartItems + 1;
                                                        _cart_items.setText("Items in cart : "+cartItems );

                                                    }else if(freshmilk.equals(freshMilk[3])) {
                                                        _fMillk = _fMillk + 3f;
                                                        cartItems = cartItems + 1;
                                                        _cart_items.setText("Items in cart : "+cartItems );

                                                    }else if(freshmilk.equals(freshMilk[4])) {
                                                        _fMillk = _fMillk + 4f;
                                                        cartItems = cartItems + 1;
                                                        _cart_items.setText("Items in cart : "+cartItems );

                                                    }else if(freshmilk.equals(freshMilk[5])) {
                                                        _fMillk = _fMillk + 5f;
                                                        cartItems = cartItems + 1;
                                                        _cart_items.setText("Items in cart : "+cartItems );


                                                    }
                                                    //Toast.makeText(MainActivity.this, selectedCountry, Toast.LENGTH_SHORT).show();
                                                }
                                            });

                                    AlertDialog dialog = builder.create();
                                    dialog.show();
                                }
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        final String[] dawnBread = {"Brown Bread","White Bread"};
        _button_wheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Dawn Bread")
                        .setItems(dawnBread, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                             //   String selectedCountry = dawnBread[i];
                                //Toast.makeText(MainActivity.this, selectedCountry, Toast.LENGTH_SHORT).show();
                                String _dawnBread = dawnBread[i];
                                if(_dawnBread.equals("Brown Bread")) {
                                     final String[] brownBread = {"Small - Rs.45","Medium - Rs.80","Large - Rs.120"};

                                    builder = new AlertDialog.Builder(MainActivity.this);
                                    builder.setTitle("Brown Bread")
                                            .setItems(brownBread, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {

                                                    String brownBrread = brownBread[i];
                                                    if(brownBrread.equals("Small - Rs.45")) {
                                                        _brownBreadSmall = _brownBreadSmall + 1;
                                                        cartItems = cartItems + 1;
                                                        _cart_items.setText("Items in cart : "+cartItems );

                                                    }else if(brownBrread.equals("Medium - Rs.80")) {
                                                        _brownBreadMedium = _brownBreadMedium + 1;
                                                        cartItems = cartItems + 1;
                                                        _cart_items.setText("Items in cart : "+cartItems );

                                                    }else if(brownBrread.equals("Large - Rs.120")) {
                                                        _brownBreadLarge = _brownBreadLarge + 1;
                                                        cartItems = cartItems + 1;
                                                        _cart_items.setText("Items in cart : "+cartItems );


                                                    }
                                                    //Toast.makeText(MainActivity.this, selectedCountry, Toast.LENGTH_SHORT).show();
                                                }
                                            });

                                    AlertDialog dialog = builder.create();
                                    dialog.show();


                                }else {
                                    final String[] whiteBread = {"Small - Rs.45","Small - Rs.80","Small - Rs.120"};
                                    builder = new AlertDialog.Builder(MainActivity.this);
                                    builder.setTitle("White Bread")
                                            .setItems(whiteBread, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {

                                                    String white_bread = whiteBread[i];
                                                    if(white_bread.equals(whiteBread[0])) {
                                                        _whiteBreadSmall = _whiteBreadSmall + 1;
                                                        cartItems = cartItems + 1;
                                                        _cart_items.setText("Items in cart : "+cartItems );

                                                    }else if(white_bread.equals(whiteBread[1])) {
                                                        _whiteBreadMedium = _whiteBreadMedium + 1;
                                                        cartItems = cartItems + 1;
                                                        _cart_items.setText("Items in cart : "+cartItems );

                                                    }else if(white_bread.equals(whiteBread[2])) {
                                                        _whiteBreadLarge = _whiteBreadLarge + 1;
                                                        cartItems = cartItems + 1;
                                                        _cart_items.setText("Items in cart : "+cartItems );
                                                    }
                                                    //Toast.makeText(MainActivity.this, selectedCountry, Toast.LENGTH_SHORT).show();
                                                }
                                            });

                                    AlertDialog dialog = builder.create();
                                    dialog.show();
                                }
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
               /* AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Bread Size")
                        .setSingleChoiceItems(radioItems, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String selectedValue = radioItems[i];
                                radioValue[0] = selectedValue;

                            }
                        });

                builder.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        cartItems = cartItems + 1;
                        _wheat = _wheat +1;
                        _cart_items.setText("Items in cart : "+cartItems );

                        if(radioValue[0].equals("Small")) {
                            _small = _small +1;

                        }else if(radioValue[0].equals("Medium")) {
                            _medium = _medium +1;
                        }else if(radioValue[0].equals("Large")) {
                            _large = _large +1;
                        }
                        Toast.makeText(MainActivity.this, "Bread is added." +radioValue[0], Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
*/
            }
        });

        findViewById(R.id.btn_checkout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cartItems == 0) {

                    Toast.makeText(MainActivity.this, "There is no items in your cart.", Toast.LENGTH_SHORT).show();
                    return;
                }


               builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();

                View dialog_layout = inflater.inflate(R.layout.user_info_dialog,null);
                final EditText txtun = (EditText) dialog_layout.findViewById(R.id.txtusername);
                final EditText txtps = (EditText) dialog_layout.findViewById(R.id.userphone);
                final EditText txtemail = (EditText) dialog_layout.findViewById(R.id.useremail);
                final EditText txtadd = (EditText) dialog_layout.findViewById(R.id.userAddress);
                builder.setView(dialog_layout)

                        .setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                 uname =txtun.getText().toString();
                                 pass = txtps.getText().toString();
                                 email = txtemail.getText().toString();
                                 addres = txtadd.getText().toString();

                                if(uname.isEmpty()) {
                                    Toast.makeText(MainActivity.this, "Name is required", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                                if(pass.isEmpty()) {
                                    Toast.makeText(MainActivity.this, "Phone is required", Toast.LENGTH_SHORT).show();
                                    return;
                                }


                                if(!isValidMail(email)) {

                                    Toast.makeText(MainActivity.this, "Please enter your correct email", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                if(email.isEmpty()) {
                                    Toast.makeText(MainActivity.this, "Email is required", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                                if(addres.isEmpty()) {
                                    Toast.makeText(MainActivity.this, "Address is required", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");

                session = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication("email(Gmail)", "Your password");
                            }
                        });

                pdialog = ProgressDialog.show(MainActivity.this, "", "Please wait for a moment...", true);
                SendEmail task = new SendEmail();
                task.execute();

                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();




            }
        });
    }

    class SendEmail extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try {
                String EMAIL_BODY = "Type whatever email body is";

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("sender gmail email"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse("receiver email"));
                message.setSubject("Check Out Details");
                message.setText(EMAIL_BODY);
//                message.setContent(textMessage, "text/html; charset=utf-8");
                Transport.send(message);

            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            pdialog.dismiss();
            startActivity(new Intent(MainActivity.this,CheckOutActivity.class));
            finish();
            //Toast.makeText(getApplicationContext(), "Details Successfully Sent!", Toast.LENGTH_LONG).show();
        }
    }


    private boolean isValidMail(String email2)
    {
        boolean check;
        Pattern p;
        Matcher m;

        String EMAIL_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        p = Pattern.compile(EMAIL_STRING);

        m = p.matcher(email2);
        check = m.matches();

        if(!check)
        {

        }
        return check;
    }


}
